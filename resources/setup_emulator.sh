#!/usr/bin/env bash

set -e

echo 'Creating emulator'
echo 'n' | $ANDROID_HOME/tools/bin/avdmanager create avd -n test-android -f -k "system-images;android-27;google_apis;x86"

echo 'loading emulator'
$ANDROID_HOME/emulator/emulator -avd test-android -no-boot-anim 
# -no-window -noaudio -verbose & 

sleep 30