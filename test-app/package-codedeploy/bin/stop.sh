#!/bin/sh
if [ -d /opt/application ]; then
	cd /opt/application
	chmod +x ./kikaha.sh
	./kikaha.sh is_running
	status=$?
	if [ "$status" = "1" ]; then
		./kikaha.sh stop || exit 1
	else
		exit 0
	fi
fi
