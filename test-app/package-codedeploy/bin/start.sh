#!/bin/sh
if [ -d /opt/application ]; then
	cd /opt/application
	chmod +x ./kikaha.sh
	./kikaha.sh start
fi