# CustomApiPlugin
This is a sample plugin project for Ant Media Server. You can use this a basis for your plugin.
With this plugin you can find:
- Accessing the Ant Media Server ie. AntMediaApplicationAdaptor class
- REST interface implementation

# Prerequests
- Install Ant Media Server
- Install Maven 

# Quick Start

- Clone the repository and go the Sample Plugin Directory
  ```sh
  git clone https://github.com/connessionetech/CustomApiPlugin.git
  cd ./CustomApiPlugin/
  ```
- Build the Sample Plugin
  ```sh
  mvn install  -Dgpg.skip=true
  ```
- Copy the generated jar file to your Ant Media Server's plugin directory
  ```sh
  cp target/CustomApiPlugin.jar /usr/local/antmedia/plugins
  ```
- Restart the Ant Media Server
  ```
  sudo service antmedia restart
  ```
