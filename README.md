# BrIAnsaveProject

Useful commands(currently only for Linux system)

# Install Gradle
  1 install sdk
    curl -s "https://get.sdkman.io" | bash
    source "$HOME/.sdkman/bin/sdkman-init.sh"
  
  2 install Gradle
    sdk install gradle 4.7
  
  3 install Gradle wrapper (only needed when 'gradlew' file missing)
    gradle wrapper --gradle-version 4.7

# Running the system
  1 Build the system
    ./gradlew build
    
  2 Run the webservice
    ./gradlew appStart
    (Runs at: http://localhost:8080/)
  
