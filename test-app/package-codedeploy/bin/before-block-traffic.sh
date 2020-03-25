#!/bin/sh

if curl -X POST http://localhost:9000/api/system/before-stop ; then
    echo "Before stop signal sent"
else
    echo "Before stop signal failed"
fi;
