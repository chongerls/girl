#!/usr/bin/env bash

killTomcat(){
  pid=`ps -ef|grep tomcat|grep java|awk '{print $2}'`
  echo "tomcat Id list :$pid"
  if [ $pid = ""]
  then
      echo "no tomcat pid value"
  else
      kill -9 $pid
  fi
}

cd $PROJ_PATH/girl
echo `pwd`
mvn clean install

killTomcat

rm -rf $TOMCAT_APP_PATH/webapps/ROOT
rm -f $TOMCAT_APP_PATH/webapps/ROOT.war
rm -f $TOMCAT_APP_PATH/webapps/*.war

cp $PROJ_PATH/girl/target/*.war $TOMCAT_APP_PATH/webapps/

cd $TOMCAT_APP_PATH/webapps/
mv *.war ROOT.war

cd $TOMCAT_APP_PATH/
sh bin/startup.sh