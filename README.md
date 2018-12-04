# react-native-nmea-library

## What is this odd place?
If by any chance you need a an ability to access NMEA data on Android 
devices from React Native you can use NMEA library.

* Support Android only.

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

## Credits
 Special thanks to kaznovac@gmail.com
