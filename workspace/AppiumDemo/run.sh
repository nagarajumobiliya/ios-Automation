cd /Users/deepti/Documents/workspace/AppiumDemo
#open -a Appium
osascript -e 'tell application "Terminal" to do script "ios_webkit_debug_proxy -c 1dae97c7b2a2203799e620d2197a6165f6e65f10:27753"'
sleep 10s
osascript -e 'tell application "Terminal" to do script "/Applications/Appium.app/Contents/Resources/node_modules/appium/build/lib/main.js --address 0.0.0.0  --port 4723 --native-instruments-lib --pre-launch --full-reset"'
sleep 30s
set classpath=/Users/deepti/Documents/workspace/AppiumDemo/lib
set classpath=/Users/deepti/Documents/workspace/AppiumDemo/bin
java -jar /Users/deepti/Documents/workspace/AppiumDemo/ios_demo.jar
killall Terminal
#osascript -e 'tell application "Terminal" close rest of (get windows) end tell'
