package io.antmedia.rest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.red5.server.api.IConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;
import com.rtmpworld.server.antmedia.plugin.sample.model.ConnectionInfo;

import io.antmedia.plugin.CustomApiPlugin;

@Component
@Path("/sample-plugin")
public class RestService {

	protected static Logger logger = LoggerFactory.getLogger(CustomApiPlugin.class);


	@Context
	protected ServletContext servletContext;
	Gson gson = new Gson();


	@GET
	@Path("/connections")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<ConnectionInfo> getConnections() {
		CustomApiPlugin plugin = getPluginApp();

		List<ConnectionInfo> result = new ArrayList<>();
		Collection<Set<IConnection>> collections = plugin.getApplication().getConnections();
		for (Set<IConnection> connections : collections) {
			for(IConnection connection : connections) {
				ConnectionInfo conn = new ConnectionInfo();
				conn.setSessionId(connection.getSessionId());
				conn.setRemoteAddress(connection.getRemoteAddress());
				result.add(conn);
			}
	    }
		return result;
	}




	private CustomApiPlugin getPluginApp() {
		ApplicationContext appCtx = (ApplicationContext) servletContext.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
		return (CustomApiPlugin) appCtx.getBean("plugin.myplugin");
	}
}
