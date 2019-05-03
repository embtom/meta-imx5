#!/bin/sh

#if [ -e /dev/input/touchscreen0 ]; then
    TSLIB_TSDEVICE=/dev/input/touchscreen0
    export TSLIB_PLUGINDIR=/usr/lib/ts
    export TSLIB_TSDEVICE
#fi

