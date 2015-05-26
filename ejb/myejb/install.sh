mvn clean install
rm /opt/jboss/jboss-as-7.1.0.Final/standalone/deployments/*.failed

cp target/myejb-1.0-SNAPSHOT.jar /opt/jboss/jboss-as-7.1.0.Final/standalone/deployments/
cp src/main/resources/standalone-full.xml /opt/jboss/jboss-as-7.1.0.Final/standalone/configuration/standalone-full.xml
