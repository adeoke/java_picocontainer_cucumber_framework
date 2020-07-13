# Pre requisites for the test.

* Maven which is greater than 3.3 (I'm using mvn 3.5.2).

* Of course Java (I've specified Java 8).

* The browser used to perform the must be installed on your machine.


You should run the tests with maven, specifying the browser name.

See an example of how to run the tests with maven specifying the chrome browser:

```shell script
mvn clean test -Dbrowser=CHROME
```

Optionally, you can choose to run the tests with the following browsers as well:

* Chrome
* FireFox
* Opera
* IE (Note that I have not tested IE on my Mac).


Final point, the final assertion that the item remains in the cart could not be performed.
In my investigations running the test either as an automated one or manual one, the items added to the cart
were removed on logging in to the application again. As a result I was not able to assert that the item in the cart is
the same item that was added to the cart before logging out of the application.

Thanks.

## License

[MIT License](https://github.com/adeoke/java_picocontainer_cucumber_framework/blob/master/LICENSE)