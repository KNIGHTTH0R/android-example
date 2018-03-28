
![Amadeus for Developers](https://raw.githubusercontent.com/amadeus4dev/developer-guides/master/images/logo.png)

# Amadeus for Developers Android Example

This project contains a sample Android application which makes use the Amadeus
for Developers APIs.

## Compilation

If you are using an IDE such as `Android Studio`, import the project and edit
the properties to configure your sdk directory location.

If you are compiling from console (OSX and Linux), open and edit the
`local.properties` file and change the sdk path variable:

For example:

```
sdk.dir=/home/user/android-sdk
```

Let's compile the project on debug mode:

```console
$ ./gradlew assembleDebug
```

## Testing

In order to test the application we will use the android emulator shipped with
the android SDK. 

First of all, we need to create an android virtual device (AVD). It's basically
an emulator configuration that allows developers to test the application by
simulating the real device capabilities. We can configure the AVD by specifying
the hardware and software options

```console
$ avdmanager create avd --force --name testAVD \
                        --abi google_apis/x86_64 \
                        --package 'system-images;android-26;google_apis;x86_64'
$ avdmanager list avd
```

Finally go to your `sdk` folder and run the emulator. For example:

```console
$ cd ~/android-sdk/emulator
$ ./emulator -avd list

Available Android targets:
----------
Available Android Virtual Devices:
    Name: testAVD
    Path: /Users/user/.android/avd/testAVD.avd
  Target: Google APIs (Google Inc.)
          Based on: Android 7.1.1 (Nougat) Tag/ABI: google_apis/x86_64
```

Start the emulation of our new virtual device:

```console
$ ./emulator -avd testAVD -skin 1440x2560
```

Open a new terminal, switch to your application source code folder and install
the package on the running emulator instance:

```console
$ ./gradlew installDebug
```


