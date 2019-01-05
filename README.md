# react-native-nmea-library

## What is this odd place?
If by any chance you need a an ability to access NMEA data on Android 
devices from React Native you can use NMEA library.

* Supports Android only.

## Getting started

`$ npm install react-native-nmea-library --save`

### Mostly automatic installation

`$ react-native link react-native-nmea-library`

### Manual installation

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNNmeaLibraryPackage;` to the imports at the top of the file
  - Add `new RNNmeaLibraryPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-nmea-library'
  	project(':react-native-nmea-library').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-nmea-library/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-nmea-library')
  	```

## Usage
```javascript
import RNNmeaLibrary from 'react-native-nmea-library';
import {DeviceEventEmitter} from 'react-native';

...

componentDidMount()
{
    RNNmeaLibrary.start();
    
    DeviceEventEmitter.addListener('onNmeaReceive', (event) => {
      console.log(event);
      
      // will output:
      // { 
      //   timestamp: 1543940192000,
      //   message: "$GLGSV,3,1,11,72,62,303,,73,59,028,,74,59,264,,71,54,180,*6" 
      // }
    });
}

componentWillUnmount() {
  RNNmeaLibrary.stop();
}
```

We recommend https://github.com/infusion/GPS.js for parsing NMEA sentances, and getting
satellite info.

##Notice
NMEA data is not available on emulators, you will have to use Android device
for testing and development.

## Credits
 * Java Support: kaznovac@gmail.com
