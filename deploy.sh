#!/usr/bin/env bash

killTomcat(){
  pid=`ps -ef|grep tomcat|grep java|awk '{print $2}'`
  echo "tomcat Id list :$pid"
  if [ "$pid" = ""]
  then
      echo "no tomcat pid value"
  else
      kill -9 $pid
  fi
}

cd $PROJ_PATH/girl
mvn clean install

killTomcat

rm -rf $TOMCAT_APP_PATH/webapps/ROOT
rm -f $TOMCAT_APP_PATH/webapps/ROOT.war
rm -f $TOMCAT_APP_PATH/webapps/girl.war

cp $PROJ_PATH/girl/target/girl.war $TOMCAT_APP_PATH/webapps/

cd $TOMCAT_APP_PATH/webapps/
mv gril.war ROOT.war

cd $TOMCAT_APP_PATH/
sh bin/startup.sh