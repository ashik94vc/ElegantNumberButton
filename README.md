<h1 align="center">Elegant Number Button</h1>

<p align="center">A simple Android library to implement a number counter with increment and decrement buttons. </p>
<p align="center">Get the sample app <a href="https://github.com/ashik94vc/ElegantNumberButton/raw/master/.github/ElegantNumberButton%20Sample.apk">HERE</a>. </p>
<p align="center">
	<a target="_blank" href="https://developer.android.com/reference/android/os/Build.VERSION_CODES.html#KITKAT"><img src="https://img.shields.io/badge/API-19%2B-blue.svg"/></a>
    <a target="_blank" href="https://bintray.com/ashik94vc/maven/elegant-number-button/_latestVersion"><img src="https://api.bintray.com/packages/ashik94vc/maven/elegant-number-button/images/download.svg"/></a>
    <a target="_blank" href="http://android-arsenal.com/details/1/4136"><img src="https://img.shields.io/badge/Android%20Arsenal-Elegant%20Number%20Button-brightgreen.svg?style=flat" border="0" alt="Android Arsenal"></a>
</p>

## Screens

<img src="https://github.com/ashik94vc/ElegantNumberButton/raw/master/screens/screen.png" alt="Screen 1" width="405" height="720"/>

<img src="https://github.com/ashik94vc/ElegantNumberButton/raw/master/screens/screen01.gif" alt="Screen 1" width="405" height="720"/>

## Download

Grab the latest version on gradle using

```groovy
compile 'com.cepheuen.elegant-number-button:lib:1.0.3'
```
or on maven

```maven
<dependency>
  <groupId>com.cepheuen.elegant-number-button</groupId>
  <artifactId>lib</artifactId>
  <version>1.0.3</version>
  <type>pom</type>
</dependency>

```

## Usage

For working implementation of this library check [ElegantNumberButtonSample App](app)
 * Just include the view as you do with any android widget.
 * Implement it in your java code as anyother widget.
 * To get the number simply call `getNumber()` method on the button object. 
 * To get the number from the button as soon as the button is clicked add a `setOnClickListener` to the view.
   
    ```java
    ElegantNumberButton button = (ElegantNumberButton) findViewById(R.id.button);
    button.setOnClickListener(new ElegantNumberButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num = button.getNumber();
            }
        });
    ```
 * Or use a valueChangeListener to listen for changes in value.
    
    ```java
    elegantNumberButton.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
            @Override
            public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {
                Log.d(TAG, String.format("oldValue: %d   newValue: %d", oldValue, newValue));
            }
        });
     ```

## Customization

`backgroundColor` : Set button Background color

`initialNumber`: Set initial number for the button.

`finalNumber` : Set final number range for button.

`textColor`: Modify the text color of the button.

`textSize`: Change text size of the button.

`backgroundDrawable`: Add drawable background for the button.

## Methods

`setNumber(Integer number)`: Update the number of the widget. 

`setRange(Integer startNumber, Integer finalNumber)` : Set the operational range for the widget

`setOnValueChangeListener(OnValueChangedListener listener)`: listen for changes in the value



## Contributing

1. Fork it!
2. Create your feature branch: `git checkout -b my-new-feature`
3. Commit your changes: `git commit -am 'Add some feature'`
4. Push to the branch: `git push origin my-new-feature`
5. Submit a pull request

## Changelog

### Version 1.0.2

* Added ValueChangeListener to listen for changes in values

### Version 1.0.1

* Added Range for the widget
* Changed attribute from initialText to initialNumber

### Version 1.0

* Initial Release

## Author

* Ashik Vetrivelu - <vcashik@gmail.com>

## License

Copyright 2016 Ashik Vetrivelu

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
