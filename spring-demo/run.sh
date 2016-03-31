export JAVA_HOME=$JAVA_8
PATH="$M2_HOME/bin:$JAVA_HOME/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/games:/usr/local/games:/opt/instantclient_12_1"
PATH="$PATH:/opt/apache-cxf-3.1.5/bin"
java -jar -Dspring.profiles.active=dev target/demo-0.0.1-SNAPSHOT.war
