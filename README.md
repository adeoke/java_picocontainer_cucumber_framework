# Pre requisites for the test.

* Maven which is greater than 3.3 (I'm using mvn 3.5.2).

* Of course Java, but I've specified Java 11 or greater.

* Browser used in test installed on your machine.


Run the tests with maven, specifying the browser name.
See an example following:

```shell script
mvn clean test -Dbrowser=CHROME
```

Which launches the browser with Chrome.

Optionally, you can choose to run the tests with the following browsers as well:

* Chrome
* FireFox
* Opera
* IE (Note that I have not tested IE on my Mac).


Final point, the final assertion that the item remains in the cart could not be performed.
When I ran the test automated or manually adding items to the cart and then logging out removed the items from the cart.

So it was a mystery to me and as such I submitted my response for you to assess as it is.

Thanks.

## License

[MIT License](https://github.com/adeoke/java_picocontainer_cucumber_framework/blob/master/LICENSE)