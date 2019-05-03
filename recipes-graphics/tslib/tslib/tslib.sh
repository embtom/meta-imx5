#!/bin/sh

#if [ -e /dev/input/touchscreen0 ]; then
    TSLIB_TSDEVICE=/dev/input/touchscreen0
    export TSLIB_CALIBFILE=/sys/devices/platform/soc/50000000.aips/53fc0000.serial/tty/ttymxc1/serio0/calibration
    export TSLIB_PLUGINDIR=/usr/lib/ts
    export TSLIB_TSDEVICE
#fi

