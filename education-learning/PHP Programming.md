# PHP Programming

[comment]: <> (Source: https://www.w3schools.com/)

## PHP Install

### Steps for running PHP script on PC

1. install a web server (Xampp, WampServer, etc.)
2. install PHP
3. install a database, such as MySQL (for database server data manipulation)

## PHP Comment

```php
<?php
// This is a single-line comment
# This is also a single-line comment

/*
This is a multiple-lines comment block
that spans over multiple
lines
*/
?>
```

## PHP Print

```php
<?php
echo "Hello World!";
print "Hello, my name is " . "John" . ".\nMy age is: " . "20" . ".";
?>
```

## PHP Variables

### Rules for PHP variables

* A variable starts with the <kbd>$</kbd> sign, followed by the name of the variable
* A variable name must start with a letter or the underscore character
* A variable name cannot start with a number
* A variable name can only contain alpha-numeric characters and underscores (A-z, 0-9, and _ )
* Variable names are case-sensitive ($age and $AGE are two different variables)

```php
<?php
$txt = "John";
$x = 5;
$y = 4;
$z = $x + $y;

echo "Hello, my name is " . $txt . ".\nMy age is: " . $z . ".";
// output = Hello, my name is John. My age is: 9
?>
```

#### PHP has three different variable scopes

* local (variable inside the function)
* global (variable outside of function)
* static (variable that cannot be changed)

```php
<?php
  $x = 10; // global scope
  static $y = 0;  // static scope

  function myTest() {
    global $x; // access a global variable
    $z = 5; // local scope
    
    echo "<p>Variable y inside function is: $z</p>" . "<p>Variable x inside function is: $x</p>";
  }
  myTest();

  echo "<p>Variable x outside function is: $x</p>";
?>
```

## PHP Datatype

### PHP supports the following data types

* String - ($txt = 'Hello World')
* Integer - ($num = 10)
* Float/double - ($x = 10.365)
* Boolean - ($x = true; $y = false;)
* Array - ($cars = array("Volvo","BMW","Toyota"))
* Object - (

```php
  class Car {
  public $color;
  public $model;
  public function __construct($color, $model) {
    $this->color = $color;
    $this->model = $model;
  }
  public function message() {
    return "My car is a " . $this->color . " " . $this->model . "!";
  }
}

$myCar = new Car("black", "Volvo");
echo $myCar -> message();
echo "<br>";
$myCar = new Car("red", "Toyota");
echo $myCar -> message();
```

)

* NULL - ($x = null;)
* Resource

## PHP String

### Common String Methods

```php
<?php
  echo strlen("Hello world!"); 
  // outputs 12

  echo str_word_count("Hello world!"); 
  // outputs 2

  echo strrev("Hello world!"); 
  // outputs !dlrow olleH

  echo strpos("Hello world!", "world"); 
  // outputs 6

  echo str_replace("world", "Dolly", "Hello world!"); 
  // outputs Hello Dolly!
?>
```

### Complete String Functions

| Function | Description |
| :------- | :---------- |
| addcslashes() | Returns a string with backslashes in front of the specified characters |
| addslashes() | Returns a string with backslashes in front of predefined characters |
| bin2hex() | Converts a string of ASCII characters to hexadecimal values |
| chop() | Removes whitespace or other characters from the right end of a string |
| chr() | Returns a character from a specified ASCII value |
| chunk_split() | Splits a string into a series of smaller parts |
| convert_cyr_string() | Converts a string from one Cyrillic character-set to another |
| convert_uudecode() | Decodes a uuencoded string |
| convert_uuencode() | Encodes a string using the uuencode algorithm |
| count_chars() | Returns information about characters used in a string |
| crc32() | Calculates a 32-bit CRC for a string |
| crypt() | One-way string hashing |
| echo() | Outputs one or more strings |
| explode() | Breaks a string into an array |
| fprintf() | Writes a formatted string to a specified output stream |
| get_html_translation_table() | Returns the translation table used by htmlspecialchars() and htmlentities() |
| hebrev() | Converts Hebrew text to visual text |
| hebrevc() | Converts Hebrew text to visual text and new lines (\n) into \<br> |
| hex2bin() | Converts a string of hexadecimal values to ASCII characters |
| html_entity_decode() | Converts HTML entities to characters |
| htmlentities() | Converts characters to HTML entities |
| htmlspecialchars_decode() | Converts some predefined HTML entities to characters |
| htmlspecialchars() | Converts some predefined characters to HTML entities |
| implode() | Returns a string from the elements of an array |
| join() | Alias of implode() |
| lcfirst() | Converts the first character of a string to lowercase |
| levenshtein() | Returns the Levenshtein distance between two strings |
| localeconv() | Returns locale numeric and monetary formatting information |
| ltrim() | Removes whitespace or other characters from the left side of a string |
| md5() | Calculates the MD5 hash of a string |
| md5_file() | Calculates the MD5 hash of a file |
| metaphone() | Calculates the metaphone key of a string |
| money_format() | Returns a string formatted as a currency string |
| nl_langinfo() | Returns specific local information |
| nl2br() | Inserts HTML line breaks in front of each newline in a string |
| number_format() | Formats a number with grouped thousands |
| ord() | Returns the ASCII value of the first character of a string |
| parse_str() | Parses a query string into variables |
| print() | Outputs one or more strings |
| printf() | Outputs a formatted string |
| quoted_printable_decode() | Converts a quoted-printable string to an 8-bit string |
| quoted_printable_encode() | Converts an 8-bit string to a quoted printable string |
| quotemeta() | Quotes meta characters |
| rtrim() | Removes whitespace or other characters from the right side of a string |
| setlocale() | Sets locale information |
| sha1() | Calculates the SHA-1 hash of a string |
| sha1_file() | Calculates the SHA-1 hash of a file |
| similar_text() | Calculates the similarity between two strings |
| soundex() | Calculates the soundex key of a string |
| sprintf() | Writes a formatted string to a variable |
| sscanf() | Parses input from a string according to a format |
| str_getcsv() | Parses a CSV string into an array |
| str_ireplace() | Replaces some characters in a string (case-insensitive) |
| str_pad() | Pads a string to a new length |
| str_repeat() | Repeats a string a specified number of times |
| str_replace() | Replaces some characters in a string (case-sensitive) |
| str_rot13() | Performs the ROT13 encoding on a string |
| str_shuffle() | Randomly shuffles all characters in a string |
| str_split() | Splits a string into an array |
| str_word_count() | Count the number of words in a string |
| strcasecmp() | Compares two strings (case-insensitive) |
| strchr() | Finds the first occurrence of a string inside another string (alias of strstr()) |
| strcmp() | Compares two strings (case-sensitive) |
| strcoll() | Compares two strings (locale based string comparison) |
| strcspn() | Returns the number of characters found in a string before any part of some specified characters are found |
| strip_tags() | Strips HTML and PHP tags from a string |
| stripcslashes() | Unquotes a string quoted with addcslashes() |
| stripslashes() | Unquotes a string quoted with addslashes() |
| stripos() | Returns the position of the first occurrence of a string inside another string (case-insensitive) |
| stristr() | Finds the first occurrence of a string inside another string (case-insensitive) |
| strlen() | Returns the length of a string |
| strnatcasecmp() | Compares two strings using a "natural order" algorithm (case-insensitive) |
| strnatcmp() | Compares two strings using a "natural order" algorithm (case-sensitive) |
| strncasecmp() | String comparison of the first n characters (case-insensitive) |
| strncmp() | String comparison of the first n characters (case-sensitive) |
| strpbrk() | Searches a string for any of a set of characters |
| strpos() | Returns the position of the first occurrence of a string inside another string (case-sensitive) |
| strrchr() | Finds the last occurrence of a string inside another string |
| strrev() | Reverses a string |
| strripos() | Finds the position of the last occurrence of a string inside another string (case-insensitive) |
| strrpos() | Finds the position of the last occurrence of a string inside another string (case-sensitive) |
| strspn() | Returns the number of characters found in a string that contains only characters from a specified charlist |
| strstr() | Finds the first occurrence of a string inside another string (case-sensitive) |
| strtok() | Splits a string into smaller strings |
| strtolower() | Converts a string to lowercase letters |
| strtoupper() | Converts a string to uppercase letters |
| strtr() | Translates certain characters in a string |
| substr() | Returns a part of a string |
| substr_compare() | Compares two strings from a specified start position (binary safe and optionally case-sensitive) |
| substr_count() | Counts the number of times a substring occurs in a string |
| substr_replace() | Replaces a part of a string with another string |
| trim() | Removes whitespace or other characters from both sides of a string |
| ucfirst() | Converts the first character of a string to uppercase |
| ucwords() | Converts the first character of each word in a string to uppercase |
| vfprintf() | Writes a formatted string to a specified output stream |
| vprintf() | Outputs a formatted string |
| vsprintf() | Writes a formatted string to a variable |
| wordwrap() | Wraps a string to a given number of characters |

## PHP Constant

* An identifier (name) for a simple value, value cannot be changed during the script.
* Constant name starts with a letter or underscore (no $ sign before the constant name).
* Syntax of constant "define(name, value, case-insensitive)"

```php
<?php
  define("GREETING", "Welcome to W3Schools.com!", true);
    define("cars", [
      "Alfa Romeo",
      "BMW",
      "Toyota"
    ]);
  echo greeting;
  // output = Welcome to W3Schools.com!
  echo cars[0];
  // output = Alfa Romeo
?>
```

## PHP Operators

```php
<?php

/* Arithmetic Operator */
// Addition
$x + $y;
// Subtraction
$x - $y;
// Multiplication
$x * $y;
// Division
$x / $y;
//Modulus
$x % $y;
// Exponentiation
$x ** $y;

/* Assignment Operator */
// The left operand gets set to the value of the expression on the right
$x = $y;
// Addition
$x += $y; 
$x = $x + $y;
// Subtraction
$x -= $y; 
$x = $x - $y
// Multiplication
$x *= $y; 
$x = $x * $y
// Division 
$x /= $y; 
$x = $x / $y 
// Modulus
$x %= $y; 
$x = $x % $y

/* Comparison Operators */
// Equal
$x == $y;
// Identical
$x === $y;
// Not equal
$x != $y;
// Not equal
$x <> $y;
// Not identical
$x !== $y;
// Greater than
$x > $y;
// Less than
$x < $y;
// Greater than or equal to
$x >= $y;
// Less than or equal to
$x <= $y;

/* Increment/ Decrement Operator */
// Pre-increment
++$x;
// Post-increment
$x++;
// Pre-decrement
--$x;
// Post-decrement
$x--;

/* Logical Operator */
// and 'And'
$x and $y;
// or 'Or'
$x or $y;
// xor 'Xor'
$x xor $y;
//  && 'And'
$x && $y;
// || 'Or'
$x || $y;
// ! 'Not'
!$x;

/* String Operator */
// Concatenation 
$txt1 . $txt2;
// Append 
$txt1 .= $txt2

/* Conditional Assignment Operator */
//?: Ternary 
$x = expr1 ? expr2 : expr3;
//?? Null coalescing 
$x = expr1 ?? expr2;
?>
```

## PHP Conditional Statement

### if... statement

```php
<?php
  $t = date("H");

  if ($t < "20") {
    echo "Have a good day!";
  }
?>
```

### if...else statement

```php
<?php
  $t = date("H");

  if ($t < "20") {
    echo "Have a good day!";
  } else {
    echo "Have a good night!";
  }
?>
```

### if...elseif...else statement

```php
<?php
  $t = date("H");

  if ($t < "10") {
    echo "Have a good morning!";
  } elseif ($t < "20") {
    echo "Have a good day!";
  } else {
    echo "Have a good night!";
  }
?>
```

### switch statement

```php
<?php
  $favcolor = "red";

  switch ($favcolor) {
    case "red":
      echo "Your favorite color is red!";
      break;
    case "blue":
      echo "Your favorite color is blue!";
      break;
    case "green":
      echo "Your favorite color is green!";
      break;
    default:
      echo "Your favorite color is neither red, blue, nor green!";
  }
?>
```

### while loop statement

```php
<?php
  $x = 0;

  while($x <= 100) {
    echo "The number is: $x <br>";
    $x+=10;
  }
?>
```

### do...while loop statement

```php
<?php
  $x = 6;

  do {
    echo "The number is: $x <br>";
    $x++;
  } while ($x <= 5);
?>
```

### for loop statement

```php
<?php
  for ($x = 0; $x <= 100; $x+=10) {
    echo "The number is: $x <br>";
  }
?>
```

### for each loop statement

```php
<?php
  $age = array("Peter"=>"35", "Ben"=>"37", "Joe"=>"43");

  foreach($age as $x => $val) {
    echo "$x = $val<br>";
  }
?>
```

### PHP Functions

### Function declaration

```php
<?php
  function familyName($fname, $year) {
    echo "$fname Refsnes. Born in $year <br>";
  }

  familyName("Hege", "1975");
  familyName("Stale", "1978");
  familyName("Kai Jim", "1983");
?>
```

### 'strict' function declaration (force function to follow the programming way(integer should input integer, string should input string))

```php
<?php declare(strict_types=1); // strict requirement, must stay at first line
  function setHeight(int $minheight = 50) {
    echo "The height is : $minheight <br>";
  }

  setHeight(350);
  setHeight(); // will use the default value of 50
  setHeight(135);
  setHeight(80);
?>
```

### function return type declaration

```php
<?php declare(strict_types=1); // strict requirement
  function addNumbers(float $a, float $b) : int {    // return value is declared as integer
    return (int)($a + $b);
  }
  echo addNumbers(1.2, 5.2);
?>
```

## PHP Array

* The one and only data structures method in PHP.
* In PHP, there are three types of arrays:
  1. Indexed arrays - Arrays with a numeric index
  2. Associative arrays - Arrays with named keys
  3. Multidimensional arrays - Arrays containing one or more arrays

### Indexed Array

```php
$cars = array("Volvo", "BMW", "Toyota");
$cars[0] = "Volvo";
$cars[1] = "BMW";
$cars[2] = "Toyota";
```

### Associate Array - Arrays that use named keys that you assign to them

```php
$age = array("Peter"=>"35", "Ben"=>"37", "Joe"=>"43");
$age['Peter'] = "35";
$age['Ben'] = "37";
$age['Joe'] = "43";
```

### Multidimensional Array - An array containing one or more arrays

```php
$cars = array (
  array("Volvo",22,18),
  array("BMW",15,13),
  array("Saab",5,2),
  array("Land Rover",17,15)
);

echo $cars[0][0].": In stock: ".$cars[0][1].", sold: ".$cars[0][2].".<br>";
echo $cars[1][0].": In stock: ".$cars[1][1].", sold: ".$cars[1][2].".<br>";
echo $cars[2][0].": In stock: ".$cars[2][1].", sold: ".$cars[2][2].".<br>";
echo $cars[3][0].": In stock: ".$cars[3][1].", sold: ".$cars[3][2].".<br>";

for ($row = 0; $row < 4; $row++) {
  echo "<p><b>Row number $row</b></p>";
  echo "<ul>";
  for ($col = 0; $col < 3; $col++) {
    echo "<li>".$cars[$row][$col]."</li>";
  }
  echo "</ul>";
}
```

### Array sorting

```php
// sort arrays in ascending order
sort();
// sort arrays in descending order
rsort();
// sort associative arrays in ascending order, according to the value
asort();
// sort associative arrays in ascending order, according to the key
ksort();
// sort associative arrays in descending order, according to the value
arsort();
// sort associative arrays in descending order, according to the key
krsort();
```

## PHP Global Variables - Superglobals

* The PHP superglobal variables are:

```php
$GLOBALS
$_SERVER
$_REQUEST
$_POST
$_GET
$_FILES
$_ENV
$_COOKIE
$_SESSION
```

## PHP Regular Expression

### preg_match()

```php
<?php
  $str = "Visit W3Schools";
  $pattern = "/w3schools/i";
  echo preg_match($pattern, $str); // Outputs 1
?>
```

### preg_match_all()

```php
<?php
  $str = "The rain in SPAIN falls mainly on the plains.";
  $pattern = "/ain/i";
  echo preg_match_all($pattern, $str); // Outputs 4
?>
```

### preg_replace()

```php
<?php
  $str = "Visit Microsoft!";
  $pattern = "/microsoft/i";
  echo preg_replace($pattern, "W3Schools", $str); // Outputs "Visit W3Schools!"
?>
```

### Regular Expression Function

| Function | Description |
| :------- | :---------- |
| preg_filter() | Returns a string or an array with pattern matches replaced, but only if matches were found |
| preg_grep() | Returns an array consisting only of elements from the input array which matched the pattern |
| preg_last_error() | Returns an error code indicating the reason that the most recent regular expression call failed |
| preg_match() | Finds the first match of a pattern in a string |
| preg_match_all() | Finds all matches of a pattern in a string |
| preg_replace() | Returns a string where matches of a pattern (or an array of patterns) are replaced with a substring (or an array of substrings) in a given string |
| preg_replace_callback() | Given an expression and a callback, returns a string where all matches of the expression are replaced with the substring returned by the callback |
| preg_replace_callback_array() | Given an array associating expressions with callbacks, returns a string where all matches of each expression are replaced with the substring returned by the callback |
| preg_split() | Breaks a string into an array using matches of a regular expression as separators |
| preg_quote() | Escapes characters that have a special meaning in regular expressions by putting a backslash in front of them |

### Regular Expression Modifiers

| Modifier | Description |
| :------- | :---------- |
| i | Performs a case-insensitive search |
| m | Performs a multiline search (patterns that search for the beginning or end of a string will match the beginning or end of each line) |
| u | Enables correct matching of UTF-8 encoded patterns |

### Regular Expression Patterns

| Expression | Description |
| :--------- | :---------- |
| \[abc] | Find one character from the options between the brackets |
| \[^abc] | Find any character NOT between the brackets |
| \[0-9] | Find one character from the range 0 to 9 |

### Metacharacters

| Metacharacter | Description |
| :------------ | :---------- |
| \| | Find a match for any one of the patterns separated by \| as in: cat|dog|fish  |
| . | Find just one instance of any character |
| ^ | Finds a match as the beginning of a string as in: ^Hello |
| $ | Finds a match at the end of the string as in: World$ |
| \d | Find a digit |
| \s | Find a whitespace character |
| \b | Find a match at the beginning of a word like this: \bWORD, or at the end of a word like this: WORD\b |
| \uxxxx | Find the Unicode character specified by the hexadecimal number xxxx |

### Quantifiers

| Quantifier | Description |
| :--------- | :---------- |
| n+ | Matches any string that contains at least one n |
| n* | Matches any string that contains zero or more occurrences of n |
| n? | Matches any string that contains zero or one occurrences of n |
| n{x} | Matches any string that contains a sequence of X n's |
| n{x,y} | Matches any string that contains a sequence of X to Y n's |
| n{x,} | Matches any string that contains a sequence of at least X n's |

## PHP Form

### PHP Form Handling

* HTML code

```html
<html>
<body>

<form action="welcome.php" method="post">
Name: <input type="text" name="name"><br>
E-mail: <input type="text" name="email"><br>
<input type="submit">
</form>

</body>
</html>
```

* PHP code (welcome.php)

```php
<html>
  <body>

    Welcome <?php echo $_POST["name"]; ?><br>
    Your email address is: <?php echo $_POST["email"]; ?>

  </body>
</html>

/* output = Welcome John
            Your email address is john.doe@example.com */
```

### PHP Form Validation

```php
// prevent using this method for form validation, will cause external hacker to insert script into server
<form method="post" action="<?php echo $_SERVER["PHP_SELF"];?>

// using htmlspecialchars() to validate form, will converts special characters to HTML entities
<form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>

// Example form validation
<!DOCTYPE HTML>  
<html>
  <head>
  </head>
  <body>  

  <?php
  // define variables and set to empty values
  $name = $email = $gender = $comment = $website = "";

  if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $name = test_input($_POST["name"]);
    $email = test_input($_POST["email"]);
    $website = test_input($_POST["website"]);
    $comment = test_input($_POST["comment"]);
    $gender = test_input($_POST["gender"]);
  }

  function test_input($data) {
    $data = trim($data);
    $data = stripslashes($data);
    $data = htmlspecialchars($data);
    return $data;
  }
  ?>

  <h2>PHP Form Validation Example</h2>
  <form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">  
    Name: <input type="text" name="name">
    <br><br>
    E-mail: <input type="text" name="email">
    <br><br>
    Website: <input type="text" name="website">
    <br><br>
    Comment: <textarea name="comment" rows="5" cols="40"></textarea>
    <br><br>
    Gender:
    <input type="radio" name="gender" value="female">Female
    <input type="radio" name="gender" value="male">Male
    <input type="radio" name="gender" value="other">Other
    <br><br>
    <input type="submit" name="submit" value="Submit">  
  </form>

  <?php
    echo "<h2>Your Input:</h2>";
    echo $name;
    echo "<br>";
    echo $email;
    echo "<br>";
    echo $website;
    echo "<br>";
    echo $comment;
    echo "<br>";
    echo $gender;
  ?>

  </body>
</html>
```

### PHP Forms - Required Fields

* Validate form data and display the error messages if wrong input

```php
<!DOCTYPE HTML>  
<html>
<head>
<style>
.error {color: #FF0000;}
</style>
</head>
<body>  

<?php
// define variables and set to empty values
$nameErr = $emailErr = $genderErr = $websiteErr = "";
$name = $email = $gender = $comment = $website = "";

if ($_SERVER["REQUEST_METHOD"] == "POST") {
  if (empty($_POST["name"])) {
    $nameErr = "Name is required";
  } else {
    $name = test_input($_POST["name"]);
  }
  
  if (empty($_POST["email"])) {
    $emailErr = "Email is required";
  } else {
    $email = test_input($_POST["email"]);
  }
    
  if (empty($_POST["website"])) {
    $website = "";
  } else {
    $website = test_input($_POST["website"]);
  }

  if (empty($_POST["comment"])) {
    $comment = "";
  } else {
    $comment = test_input($_POST["comment"]);
  }

  if (empty($_POST["gender"])) {
    $genderErr = "Gender is required";
  } else {
    $gender = test_input($_POST["gender"]);
  }
}

function test_input($data) {
  $data = trim($data);
  $data = stripslashes($data);
  $data = htmlspecialchars($data);
  return $data;
}
?>

<h2>PHP Form Validation Example</h2>
<p><span class="error">* required field</span></p>
<form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">  
  Name: <input type="text" name="name">
  <span class="error">* <?php echo $nameErr;?></span>
  <br><br>
  E-mail: <input type="text" name="email">
  <span class="error">* <?php echo $emailErr;?></span>
  <br><br>
  Website: <input type="text" name="website">
  <span class="error"><?php echo $websiteErr;?></span>
  <br><br>
  Comment: <textarea name="comment" rows="5" cols="40"></textarea>
  <br><br>
  Gender:
  <input type="radio" name="gender" value="female">Female
  <input type="radio" name="gender" value="male">Male
  <input type="radio" name="gender" value="other">Other
  <span class="error">* <?php echo $genderErr;?></span>
  <br><br>
  <input type="submit" name="submit" value="Submit">  
</form>

<?php
  echo "<h2>Your Input:</h2>";
  echo $name;
  echo "<br>";
  echo $email;
  echo "<br>";
  echo $website;
  echo "<br>";
  echo $comment;
  echo "<br>";
  echo $gender;
?>

</body>
</html>
```

### PHP - Validate Name, E-mail, and URL

```php
<!DOCTYPE HTML>  
<html>
<head>
<style>
.error {color: #FF0000;}
</style>
</head>
<body>  

<?php
// define variables and set to empty values
$nameErr = $emailErr = $genderErr = $websiteErr = "";
$name = $email = $gender = $comment = $website = "";

if ($_SERVER["REQUEST_METHOD"] == "POST") {
  if (empty($_POST["name"])) {
    $nameErr = "Name is required";
  } else {
    $name = test_input($_POST["name"]);
    // check if name only contains letters and whitespace
    if (!preg_match("/^[a-zA-Z-' ]*$/",$name)) {
      $nameErr = "Only letters and white space allowed";
    }
  }
  
  if (empty($_POST["email"])) {
    $emailErr = "Email is required";
  } else {
    $email = test_input($_POST["email"]);
    // check if e-mail address is well-formed
    if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
      $emailErr = "Invalid email format";
    }
  }
    
  if (empty($_POST["website"])) {
    $website = "";
  } else {
    $website = test_input($_POST["website"]);
    // check if URL address syntax is valid
    if (!preg_match("/\b(?:(?:https?|ftp):\/\/|www\.)[-a-z0-9+&@#\/%?=~_|!:,.;]*[-a-z0-9+&@#\/%=~_|]/i",$website)) {
      $websiteErr = "Invalid URL";
    }    
  }

  if (empty($_POST["comment"])) {
    $comment = "";
  } else {
    $comment = test_input($_POST["comment"]);
  }

  if (empty($_POST["gender"])) {
    $genderErr = "Gender is required";
  } else {
    $gender = test_input($_POST["gender"]);
  }
}

function test_input($data) {
  $data = trim($data);
  $data = stripslashes($data);
  $data = htmlspecialchars($data);
  return $data;
}
?>

<h2>PHP Form Validation Example</h2>
<p><span class="error">* required field</span></p>
<form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">  
  Name: <input type="text" name="name">
  <span class="error">* <?php echo $nameErr;?></span>
  <br><br>
  E-mail: <input type="text" name="email">
  <span class="error">* <?php echo $emailErr;?></span>
  <br><br>
  Website: <input type="text" name="website">
  <span class="error"><?php echo $websiteErr;?></span>
  <br><br>
  Comment: <textarea name="comment" rows="5" cols="40"></textarea>
  <br><br>
  Gender:
  <input type="radio" name="gender" value="female">Female
  <input type="radio" name="gender" value="male">Male
  <input type="radio" name="gender" value="other">Other
  <span class="error">* <?php echo $genderErr;?></span>
  <br><br>
  <input type="submit" name="submit" value="Submit">  
</form>

<?php
  echo "<h2>Your Input:</h2>";
  echo $name;
  echo "<br>";
  echo $email;
  echo "<br>";
  echo $website;
  echo "<br>";
  echo $comment;
  echo "<br>";
  echo $gender;
?>

</body>
</html>
```

### PHP Complete Form Example

```php
<!DOCTYPE HTML>  
<html>
<head>
  <style>
    .error {color: #FF0000;}
  </style>
</head>
<body>

<?php
  // define variables and set to empty values
  $nameErr = $emailErr = $genderErr = $websiteErr = "";
  $name = $email = $gender = $comment = $website = "";

  if ($_SERVER["REQUEST_METHOD"] == "POST") {
    if (empty($_POST["name"])) {
      $nameErr = "Name is required";
    } else {
      $name = test_input($_POST["name"]);
      // check if name only contains letters and whitespace
      if (!preg_match("/^[a-zA-Z-' ]*$/",$name)) {
        $nameErr = "Only letters and white space allowed";
      }
    }
    
    if (empty($_POST["email"])) {
      $emailErr = "Email is required";
    } else {
      $email = test_input($_POST["email"]);
      // check if e-mail address is well-formed
      if (!filter_var($email, FILTER_VALIDATE_EMAIL)) {
        $emailErr = "Invalid email format";
      }
    }
      
    if (empty($_POST["website"])) {
      $website = "";
    } else {
      $website = test_input($_POST["website"]);
      // check if URL address syntax is valid (this regular expression also allows dashes in the URL)
      if (!preg_match("/\b(?:(?:https?|ftp):\/\/|www\.)[-a-z0-9+&@#\/%?=~_|!:,.;]*[-a-z0-9+&@#\/%=~_|]/i",$website)) {
        $websiteErr = "Invalid URL";
      }
    }

    if (empty($_POST["comment"])) {
      $comment = "";
    } else {
      $comment = test_input($_POST["comment"]);
    }

    if (empty($_POST["gender"])) {
      $genderErr = "Gender is required";
    } else {
      $gender = test_input($_POST["gender"]);
    }
  }

  function test_input($data) {
    $data = trim($data);
    $data = stripslashes($data);
    $data = htmlspecialchars($data);
    return $data;
  }
?>

  <h2>PHP Form Validation Example</h2>
  <p><span class="error">* required field</span></p>
  <form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">  
    Name: <input type="text" name="name" value="<?php echo $name;?>">
    <span class="error">* <?php echo $nameErr;?></span>
    <br><br>
    E-mail: <input type="text" name="email" value="<?php echo $email;?>">
    <span class="error">* <?php echo $emailErr;?></span>
    <br><br>
    Website: <input type="text" name="website" value="<?php echo $website;?>">
    <span class="error"><?php echo $websiteErr;?></span>
    <br><br>
    Comment: <textarea name="comment" rows="5" cols="40"><?php echo $comment;?></textarea>
    <br><br>
    Gender:
    <input type="radio" name="gender" <?php if (isset($gender) && $gender=="female") echo "checked";?> value="female">Female
    <input type="radio" name="gender" <?php if (isset($gender) && $gender=="male") echo "checked";?> value="male">Male
    <input type="radio" name="gender" <?php if (isset($gender) && $gender=="other") echo "checked";?> value="other">Other  
    <span class="error">* <?php echo $genderErr;?></span>
    <br><br>
    <input type="submit" name="submit" value="Submit">  
  </form>

  <?php
  echo "<h2>Your Input:</h2>";
  echo $name;
  echo "<br>";
  echo $email;
  echo "<br>";
  echo $website;
  echo "<br>";
  echo $comment;
  echo "<br>";
  echo $gender;
?>

</body>
</html>
```

## PHP Datetime

```php
<!DOCTYPE html>
<html>
<body>

<?php
// Get date
echo "Today is " . date("Y/m/d") . "<br>";
echo "Today is " . date("Y.m.d") . "<br>";
echo "Today is " . date("Y-m-d") . "<br>";
echo "Today is " . date("l");

// Get time with time zone
date_default_timezone_set("Asia/Kuala_Lumpur");
echo "The time is " . date("h:i:sa");

// Creating a date using mktime()
$d=mktime(11, 14, 54, 8, 12, 2014);
echo "Created date is " . date("Y-m-d h:i:sa", $d);

// Creating a date from a string using strtotime()
$d=strtotime("10:30pm April 15 2014");
echo "Created date is " . date("Y-m-d h:i:sa", $d);

// current date add one day
$d=strtotime("tomorrow");
echo date("Y-m-d h:i:sa", $d) . "<br>";

// current date go to next saturday
$d=strtotime("next Saturday");
echo date("Y-m-d h:i:sa", $d) . "<br>";

// current date add 3 months
$d=strtotime("+3 Months");
echo date("Y-m-d h:i:sa", $d) . "<br>";
?>

</body>
</html>
```

## PHP Include Module

### include statement

* "include" is used to insert the content of one PHP file into another PHP file (before the server executes it), with the include or require statement.
* will only produce a warning (E_WARNING) and the script will continue

```php
<!DOCTYPE html>
<html>
  <body>

  <h1>Welcome to my home page!</h1>
  <p>Some text.</p>
  <p>Some more text.</p>
  <?php include 'footer.php';?>

  </body>
</html>

// File name "menu.php"
<?php
echo '<a href="/default.asp">Home</a> -
<a href="/html/default.asp">HTML Tutorial</a> -
<a href="/css/default.asp">CSS Tutorial</a> -
<a href="/js/default.asp">JavaScript Tutorial</a> -
<a href="default.asp">PHP Tutorial</a>';
?>

// File name "show.php", use include statement to include elements from menu.php
<!DOCTYPE html>
<html>
<body>

<div class="menu">
<?php include 'menu.php';?>
</div>

<h1>Welcome to my home page!</h1>
<p>Some text.</p>
<p>Some more text.</p>

</body>
</html>
```

### require_once statement

* "require_once" keyword is used to embed PHP code from another file. If the file is not found, a fatal error is thrown and the program stops. If the file was already included previously, this statement will not include it again.

```php
<!DOCTYPE html>
<html>
<body>

<h1>Welcome to my home page!</h1>
<p>Some text.</p>
<p>Some more text.</p>
<?php require_once 'footer.php';?>

</body>
</html>
```

## PHP File Handling

* File may opened with following modes:

| Modes | Description |
| :---- | :---------- |
| r | Open a file for read only. File pointer starts at the beginning of the file |
| w | Open a file for write only. Erases the contents of the file or creates a new file if it doesn't exist. File pointer starts at the beginning of the file |
| a | Open a file for write only. The existing data in file is preserved. File pointer starts at the end of the file. Creates a new file if the file doesn't exist |
| x | Creates a new file for write only. Returns FALSE and an error if file already exists |
| r+ | Open a file for read/write. File pointer starts at the beginning of the file |
| w+ | Open a file for read/write. Erases the contents of the file or creates a new file if it doesn't exist. File pointer starts at the beginning of the file |
| a+ | Open a file for read/write. The existing data in file is preserved. File pointer starts at the end of the file. Creates a new file if the file doesn't exist |
| x+ | Creates a new file for read/write. Returns FALSE and an error if file already exists |

```php
<?php
// simple file read method
$myfile = fopen("log.txt", "r") or die("Unable to open file!");
echo fread($myfile,filesize("log.txt"));
fclose($myfile);

// read single line from a file
$myfile = fopen("log.txt", "r") or die("Unable to open file!");
echo fgets($myfile);
fclose($myfile);

// feof() reads the "log.txt" file line by line, until end-of-file is reached
$myfile = fopen("log.txt", "r") or die("Unable to open file!");
while(!feof($myfile)) {
  echo fgets($myfile) . "<br>";
}
fclose($myfile);

// fwrite() write data into file, will rewrite the existing file data
$myfile = fopen("newfile.txt", "w") or die("Unable to open file!");
$txt = "Mickey Mouse\n";
fwrite($myfile, $txt);
$txt = "Minnie Mouse\n";
fwrite($myfile, $txt);
fclose($myfile);

// fwrite() with fopen() append method, will keep the existing data and append new data into the file
$myfile = fopen("newfile.txt", "a") or die("Unable to open file!");
$txt = "Mickey Mouse\n";
fwrite($myfile, $txt);
$txt = "Minnie Mouse\n";
fwrite($myfile, $txt);
fclose($myfile);

?>
```

### File system function

| Function | Description |
| :------- | :---------- |
| basename() | Returns the filename component of a path |
| chgrp() | Changes the file group |
| chmod() | Changes the file mode |
| chown() | Changes the file owner |
| clearstatcache() | Clears the file status cache |
| copy() | Copies a file |
| delete() | See unlink() |
| dirname() | Returns the directory name component of a path |
| disk_free_space() | Returns the free space of a filesystem or disk |
| disk_total_space() | Returns the total size of a filesystem or disk |
| diskfreespace() | Alias of disk_free_space() |
| fclose() | Closes an open file |
| feof() | Checks if the "end-of-file" (EOF) has been reached for an open file |
| fflush() | Flushes buffered output to an open file |
| fgetc() | Returns a single character from an open file |
| fgetcsv() | Returns a line from an open CSV file |
| fgets() | Returns a line from an open file |
| fgetss() | Deprecated from PHP 7.3. Returns a line from an open file - stripped from HTML and PHP tags |
| file() | Reads a file into an array |
| file_exists() | Checks whether or not a file or directory exists |
| file_get_contents() | Reads a file into a string |
| file_put_contents() | Writes data to a file |
| fileatime() | Returns the last access time of a file |
| filectime() | Returns the last change time of a file |
| filegroup() | Returns the group ID of a file |
| fileinode() | Returns the inode number of a file |
| filemtime() | Returns the last modification time of a file |
| fileowner() | Returns the user ID (owner) of a file |
| fileperms() | Returns the file's permissions |
| filesize() | Returns the file size |
| filetype() | Returns the file type |
| flock() | Locks or releases a file |
| fnmatch() | Matches a filename or string against a specified pattern |
| fopen() | Opens a file or URL |
| fpassthru() | Reads from the current position in a file - until EOF, and writes the result to the output buffer |
| fputcsv() | Formats a line as CSV and writes it to an open file |
| fputs() | Alias of fwrite() |
| fread() | Reads from an open file (binary-safe) |
| fscanf() | Parses input from an open file according to a specified format |
| fseek() | Seeks in an open file |
| fstat() | Returns information about an open file |
| ftell() | Returns the current position in an open file |
| ftruncate() | Truncates an open file to a specified length |
| fwrite() | Writes to an open file (binary-safe) |
| glob() | Returns an array of filenames / directories matching a specified pattern |
| is_dir() | Checks whether a file is a directory |
| is_executable() | Checks whether a file is executable |
| is_file() | Checks whether a file is a regular file |
| is_link() | Checks whether a file is a link |
| is_readable() | Checks whether a file is readable |
| is_uploaded_file() | Checks whether a file was uploaded via HTTP POST |
| is_writable() | Checks whether a file is writable |
| is_writeable() | Alias of is_writable() |
| lchgrp() | Changes the group ownership of a symbolic link |
| lchown() | Changes the user ownership of a symbolic link |
| link() | Creates a hard link |
| linkinfo() | Returns information about a hard link |
| lstat() | Returns information about a file or symbolic link |
| mkdir() | Creates a directory |
| move_uploaded_file() | Moves an uploaded file to a new location |
| parse_ini_file() | Parses a configuration file |
| parse_ini_string() | Parses a configuration string |
| pathinfo() | Returns information about a file path |
| pclose() | Closes a pipe opened by popen() |
| popen() | Opens a pipe |
| readfile() | Reads a file and writes it to the output buffer |
| readlink() | Returns the target of a symbolic link |
| realpath() | Returns the absolute pathname |
| realpath_cache_get() | Returns realpath cache entries |
| realpath_cache_size() | Returns realpath cache size |
| rename() | Renames a file or directory |
| rewind() | Rewinds a file pointer |
| rmdir() | Removes an empty directory |
| set_file_buffer() | Alias of stream_set_write_buffer(). Sets the buffer size for write operations on the given file |
| stat() | Returns information about a file |
| symlink() | Creates a symbolic link |
| tempnam() | Creates a unique temporary file |
| tmpfile() | Creates a unique temporary file |
| touch() | Sets access and modification time of a file |
| umask() | Changes file permissions for files |
| unlink() | Deletes a file |

### PHP File upload method

* html form with upload input

```html
<!DOCTYPE html>
<html>
<body>

<form action="upload.php" method="post" enctype="multipart/form-data">
  Select image to upload:
  <input type="file" name="fileToUpload" id="fileToUpload">
  <input type="submit" value="Upload Image" name="submit">
</form>

</body>
</html>
```

* PHP file upload methods

```php
<?php
// file directory that keeps uploaded file
$target_dir = "uploads/";
$target_file = $target_dir . basename($_FILES["fileToUpload"]["name"]);
$uploadOk = 1;
$imageFileType = strtolower(pathinfo($target_file,PATHINFO_EXTENSION));

// Check if image file is a actual image or fake image
if(isset($_POST["submit"])) {
  $check = getimagesize($_FILES["fileToUpload"]["tmp_name"]);
  if($check !== false) {
    echo "File is an image - " . $check["mime"] . ".";
    $uploadOk = 1;
  } else {
    echo "File is not an image.";
    $uploadOk = 0;
  }
}

// Check if file already exists
if (file_exists($target_file)) {
  echo "Sorry, file already exists.";
  $uploadOk = 0;
}

// Check file size
if ($_FILES["fileToUpload"]["size"] > 500000) {
  echo "Sorry, your file is too large.";
  $uploadOk = 0;
}

// Allow certain file formats
if($imageFileType != "jpg" && $imageFileType != "png" && $imageFileType != "jpeg"
&& $imageFileType != "gif" ) {
  echo "Sorry, only JPG, JPEG, PNG & GIF files are allowed.";
  $uploadOk = 0;
}

// Check if $uploadOk is set to 0 by an error
if ($uploadOk == 0) {
  echo "Sorry, your file was not uploaded.";
// if everything is ok, try to upload file
} else {
  if (move_uploaded_file($_FILES["fileToUpload"]["tmp_name"], $target_file)) {
    echo "The file ". htmlspecialchars( basename( $_FILES["fileToUpload"]["name"])). " has been uploaded.";
  } else {
    echo "Sorry, there was an error uploading your file.";
  }
}
?>
```

## PHP Cookies

```php
<?php
$cookie_name = "user";
$cookie_value = "John Doe";
// setcookie(name, value, expire, path, domain, secure, httponly);
setcookie($cookie_name, $cookie_value, time() + (86400 * 30), "/"); // 86400 = 1 day
?>
<html>
<body>

// Validate cookie
<?php
if(!isset($_COOKIE[$cookie_name])) {
  echo "Cookie named '" . $cookie_name . "' is not set!";
} else {
  echo "Cookie '" . $cookie_name . "' is set!<br>";
  echo "Value is: " . $_COOKIE[$cookie_name];
}
?>

// Delete Cookie
<?php
// set the expiration date to one hour ago
setcookie("user", "", time() - 3600);
?>
<html>
<body>

<?php
echo "Cookie 'user' is deleted.";
?>

// Check cookie are enabled
<?php
if(count($_COOKIE) > 0) {
  echo "Cookies are enabled.";
} else {
  echo "Cookies are disabled.";
}
?>
</body>
</html>
```

## PHP Sessions

```php
<?php
// Start the session, must stay at the beginning of html
session_start();
?>
<!DOCTYPE html>
<html>
<body>

// Set session variables
<?php
$_SESSION["favcolor"] = "green";
$_SESSION["favanimal"] = "cat";
echo "Session variables are set.";
?>

<?php
print_r($_SESSION);
?>

// Echo session variables that were set on previous page
<?php
echo "Favorite color is " . $_SESSION["favcolor"] . ".<br>";
echo "Favorite animal is " . $_SESSION["favanimal"] . ".";
?>

// to change a session variable, just overwrite it
<?php
$_SESSION["favcolor"] = "yellow";
print_r($_SESSION);
?>

// Delete session
<?php
// remove all session variables
session_unset();

// destroy the session
session_destroy();
?>

</body>
</html>
```

## PHP Filter

### PHP Filter Functions

| Function | Description |
| :------- | :---------- |
| filter_has_var() | Checks whether a variable of a specified input type exist |
| filter_id() | Returns the filter ID of a specified filter name |
| filter_input() | Gets an external variable (e.g. from form input) and optionally filters it |
| filter_input_array() | Gets external variables (e.g. from form input) and optionally filters them |
| filter_list() | Returns a list of all supported filter names |
| filter_var() | Filters a variable with a specified filter |
| filter_var_array() | Gets multiple variables and filter them |

### PHP Predefined Filter Constants

| Constant | Description |
| :------- | :---------- |
| INPUT_POST | POST variables |
| INPUT_GET | GET variables |
| INPUT_COOKIE | COOKIE variables |
| INPUT_ENV | ENV variables |
| INPUT_SERVER | SERVER variables |
| FILTER_DEFAULT | Do nothing, optionally strip/encode special characters. Equivalent to FILTER_UNSAFE_RAW |
| FILTER_FLAG_NONE | Allows no flags |
| FILTER_FLAG_ALLOW_OCTAL | Only for inputs that starts with a zero (0) as octal numbers. This only allows the succeeding digits to be 0-7 |
| FILTER_FLAG_ALLOW_HEX | Only for inputs that starts with 0x/0X as hexadecimal numbers. This only allows succeeding characters to be a-fA-F0-9 |
| FILTER_FLAG_STRIP_LOW | Strip characters with ASCII value lower than 32 |
| FILTER_FLAG_STRIP_HIGH | Strip characters with ASCII value greater than 127 |
| FILTER_FLAG_ENCODE_LOW | Encode characters with ASCII value lower than 32 |
| FILTER_FLAG_ENCODE_HIGH | Encode characters with ASCII value greater than 127 |
| FILTER_FLAG_ENCODE_AMP | Encode & |
| FILTER_FLAG_NO_ENCODE_QUOTES | Do not encode ' and " |
| FILTER_FLAG_EMPTY_STRING_NULL | Not in use |
| FILTER_FLAG_ALLOW_FRACTION | Allows a period (.) as a fractional separator in numbers |
| FILTER_FLAG_ALLOW_THOUSAND | Allows a comma (,) as a thousands separator in numbers |
| FILTER_FLAG_ALLOW_SCIENTIFIC | Allows an e or E for scientific notation in numbers |
| FILTER_FLAG_PATH_REQUIRED | The URL must contain a path part |
| FILTER_FLAG_QUERY_REQUIRED | The URL must contain a query string |
| FILTER_FLAG_IPV4 | Allows the IP address to be in IPv4 format |
| FILTER_FLAG_IPV6 | Allows the IP address to be in IPv6 format |
| FILTER_FLAG_NO_RES_RANGE | Fails validation for the reserved IPv4 ranges: 0.0.0.0/8, 169.254.0.0/16, 127.0.0.0/8 and 240.0.0.0/4, and for the reserved IPv6 ranges: ::1/128, ::/128, ::ffff:0:0/96 and fe80::/10 |
| FILTER_FLAG_NO_PRIV_RANGE | Fails validation for the private IPv4 ranges: 10.0.0.0/8, 172.16.0.0/12 and 192.168.0.0/16, and for the IPv6 addresses starting with FD or FC |
| FILTER_FLAG_EMAIL_UNICODE | Allows the local part of the email address to contain Unicode characters |
| FILTER_REQUIRE_SCALAR | The value must be a scalar |
| FILTER_REQUIRE_ARRAY | The value must be an array |
| FILTER_FORCE_ARRAY | Treats a scalar value as array with the scalar value as only element |
| FILTER_NULL_ON_FAILURE | Return NULL on failure for unrecognized boolean values |
| FILTER_VALIDATE_BOOLEAN | Validates a boolean |
| FILTER_VALIDATE_EMAIL | Validates value as a valid e-mail address |
| FILTER_VALIDATE_FLOAT | Validates value as float |
| FILTER_VALIDATE_INT | Validates value as integer |
| FILTER_VALIDATE_IP | Validates value as IP address |
| FILTER_VALIDATE_MAC | Validates value as MAC address |
| FILTER_VALIDATE_REGEXP | Validates value against a regular expression |
| FILTER_VALIDATE_URL | Validates value as URL |
| FILTER_SANITIZE_EMAIL | Removes all illegal characters from an e-mail address |
| FILTER_SANITIZE_ENCODED | Removes/Encodes special characters |
| FILTER_SANITIZE_MAGIC_QUOTES | Apply addslashes() |
| FILTER_SANITIZE_NUMBER_FLOAT | Remove all characters, except digits, +- signs, and optionally .,eE |
| FILTER_SANITIZE_NUMBER_INT | Removes all characters except digits and + - signs |
| FILTER_SANITIZE_SPECIAL_CHARS | Removes special characters |
| FILTER_SANITIZE_STRING | Removes tags/special characters from a string |
| FILTER_SANITIZE_STRIPPED | Alias of FILTER_SANITIZE_STRING |
| FILTER_SANITIZE_URL | Removes all illegal character from a URL |
| FILTER_UNSAFE_RAW | Do nothing, optionally strip/encode special characters |
| FILTER_CALLBACK | Call a user-defined function to filter data |

### Example PHP filter function

```php
// use the filter_var() function to sanitize a string
<?php
$str = "<h1>Hello WorldÆØÅ!</h1>";

$newstr = filter_var($str, FILTER_SANITIZE_STRING, FILTER_FLAG_STRIP_HIGH);
echo $newstr;
?>
```

### PHP Callback Functions

* a function which is passed as an argument into another function

```php
<?php
function exclaim($str) {
  return $str . "! ";
}

function ask($str) {
  return $str . "? ";
}

function printFormatted($str, $format) {
  // Calling the $format callback function
  echo $format($str);
}

// Pass "exclaim" and "ask" as callback functions to printFormatted()
printFormatted("Hello world", "exclaim");
printFormatted("Hello world", "ask");
?>
```

## PHP Exception Handling

* PHP Exception methods

| Method | Description |
| :----- | :---------- |
| Exception() | The contructor of the Exception object |
| getCode() | Returns the exception code |
| getFile() | Returns the full path of the file in which the exception was thrown |
| getMessage() | Returns a string describing why the exception was thrown |
| getLine() | Returns the line number of the line of code which threw the exception |
| getPrevious() | If this exception was triggered by another one, this method returns the previous exception. If not, then it returns null |
| getTrace() | Returns an array with information about all of the functions that were running at the time the exception was thrown |
| getTraceAsString() | Returns the same information as getTrace(), but in a string |

* try...catch...finally statements

```php
<?php
function divide($dividend, $divisor) {
  if($divisor == 0) {
    throw new Exception("Division by zero");
  }
  return $dividend / $divisor;
}

try {
  echo divide(5, 0);
} catch(Exception $e) {
  echo "Unable to divide. ";
} finally {
  echo "Process complete.";
}
?>
```

* Exception with specific return message

```php
<?php
function divide($dividend, $divisor) {
  if($divisor == 0) {
    throw new Exception("Division by zero", 1);
  }
  return $dividend / $divisor;
}

try {
  echo divide(5, 0);
} catch(Exception $ex) {
  $code = $ex->getCode();
  $message = $ex->getMessage();
  $file = $ex->getFile();
  $line = $ex->getLine();
  echo "Exception thrown in $file on line $line: [Code $code]
  $message";
}
?>
```

## PHP Object-Oriented Programming

### Classes and Objects

```php
<?php
class Fruit {
  // Properties
  public $name;
  public $color;

  // Methods
  function set_name($name) {
    $this->name = $name;
  }
  function get_name() {
    return $this->name;
  }
  function set_color($color) {
    $this->color = $color;
  }
  function get_color() {
    return $this->color;
  }
}

$apple = new Fruit();
$apple->set_name('Apple');              // in Java/ Python, we called it "apple.set_name('apple')"
$apple->set_color('Red');
echo "Name: " . $apple->get_name();
echo "<br>";
echo "Color: " . $apple->get_color();
?>
```

### PHP Constructor (getter and setter)

```php
<?php
class Fruit {
  public $name;
  public $color;

  // setter
  function __construct($name, $color) {
    $this->name = $name;
    $this->color = $color;
  }
  // getter
  function get_name() {
    return $this->name;
  }
  // getter
  function get_color() {
    return $this->color;
  }
}

// set object with data
$apple = new Fruit("Apple", "red");
// get data
echo $apple->get_name();
echo "<br>";
//get data
echo $apple->get_color();
?>
```

### PHP Destructor

* A destructor is called when the object is destructed or the script is stopped or exited.
* Similar as getter method

```php
<?php
class Fruit {
  public $name;
  public $color;

  function __construct($name, $color) {
    $this->name = $name;
    $this->color = $color;
  }
  function __destruct() {
    echo "The fruit is {$this->name} and the color is {$this->color}.";
  }
}

$apple = new Fruit("Apple", "red");
?>
// output will be "The fruit is Apple and the color is red." 
// extract after script end
```

### PHP Eccess Modifier

* There are three access modifiers:
  1. <kbd>public</kbd> - the property or method can be accessed from everywhere. This is default
  2. <kbd>protected</kbd> - the property or method can be accessed within the class and by classes derived from that class
  3. <kbd>private</kbd> - the property or method can ONLY be accessed within the class

```php
// Objects with access modifier
<?php
class Fruit {
  public $name;
  protected $color;
  private $weight;
}

$mango = new Fruit();
$mango->name = 'Mango'; // OK
$mango->color = 'Yellow'; // ERROR
$mango->weight = '300'; // ERROR
?>

// Methods with access modifier
<?php
class Fruit {
  public $name;
  public $color;
  public $weight;

  function set_name($n) {  // a public function (default)
    $this->name = $n;
  }
  protected function set_color($n) { // a protected function
    $this->color = $n;
  }
  private function set_weight($n) { // a private function
    $this->weight = $n;
  }
}

$mango = new Fruit();
$mango->set_name('Mango'); // OK
$mango->set_color('Yellow'); // ERROR
$mango->set_weight('300'); // ERROR
?>
```

### PHP Inheritance

```php
<?php
class Fruit {
  public $name;
  public $color;
  public function __construct($name, $color) {
    $this->name = $name;
    $this->color = $color;
  }
  public function intro() {
    echo "The fruit is {$this->name} and the color is {$this->color}.";
  }
}

// Strawberry is inherited from Fruit
class Strawberry extends Fruit {
  public function message() {
    echo "Am I a fruit or a berry? ";
  }
}
$strawberry = new Strawberry("Strawberry", "red");
$strawberry->message();
$strawberry->intro();
?>
```

### PHP Constants

* Constants cannot be changed once it is declared.

```php
<?php
class Goodbye {
  const LEAVING_MESSAGE = "Thank you for visiting W3Schools.com!";
  public function byebye() {
    // access a constant from inside the class by using the self keyword followed by the scope resolution operator (::) followed by the constant name
    echo self::LEAVING_MESSAGE;
  }
}

$goodbye = new Goodbye();
$goodbye->byebye();
?>
```

### PHP Abstract Classes

```php
<!DOCTYPE html>
<html>
<body>

<?php
abstract class ParentClass {
  // Abstract method with an argument
  abstract protected function prefixName($name);
}

class ChildClass extends ParentClass {
  // The child class may define optional arguments that is not in the parent's abstract method
  public function prefixName($name, $separator = ".", $greet = "Dear") {
    if ($name == "John Doe") {
      $prefix = "Mr";
    } elseif ($name == "Jane Doe") {
      $prefix = "Mrs";
    } else {
      $prefix = "";
    }
    return "{$greet} {$prefix}{$separator} {$name}";
  }
}

$class = new ChildClass;
echo $class->prefixName("John Doe");
echo "<br>";  
echo $class->prefixName("Jane Doe");
?>
 
</body>
</html>
```

### PHP Interface

```php
<?php
// Interface definition
interface Animal {
  public function makeSound();
}

// Class definitions
class Cat implements Animal {
  public function makeSound() {
    echo " Meow ";
  }
}

class Dog implements Animal {
  public function makeSound() {
    echo " Bark ";
  }
}

class Mouse implements Animal {
  public function makeSound() {
    echo " Squeak ";
  }
}

// Create a list of animals
$cat = new Cat();
$dog = new Dog();
$mouse = new Mouse();
$animals = array($cat, $dog, $mouse);

// Tell the animals to make a sound
foreach($animals as $animal) {
  $animal->makeSound();
}
?>
```

### PHP Traits

* Traits are used to declare methods that can be used in multiple classes.
* Traits can have methods and abstract methods that can be used in multiple classes, and the methods can have any access modifier (public, private, or protected).

```php
<?php
trait message1 {
  public function msg1() {
    echo "OOP is fun! ";
  }
}

trait message2 {
  public function msg2() {
    echo "OOP reduces code duplication!";
  }
}

class Welcome {
  use message1;
}

class Welcome2 {
  use message1, message2;
}

$obj = new Welcome();
$obj->msg1();
echo "<br>";

$obj2 = new Welcome2();
$obj2->msg1();
$obj2->msg2();
?>
```

### PHP Static Method

* Static methods can be called directly without creating an instance of the class first.
* A static method can be accessed from a method in the same class using the self keyword and double colon (::)

```php
<?php
class domain {
  protected static function getWebsiteName() {
    return "W3Schools.com";
  }
}

class domainW3 extends domain {
  public $websiteName;
  public function __construct() {
    $this->websiteName = parent::getWebsiteName();
  }
}

$domainW3 = new domainW3;
echo $domainW3 -> websiteName;
?>
```

### PHP Namespaces

* In a short word, similar as package in Java or module in Python
* Example:

* Html.php

```php
<?php
// class name Html
namespace Html;
class Table {
  public $title = "";
  public $numRows = 0;

  public function message() {
    echo "<p>Table '{$this->title}' has {$this->numRows} rows.</p>";
  }
}

class Row {
  public $numCells = 0;
  public function message() {
    echo "<p>The row has {$this->numCells} cells.</p>";
  }
}
?>
```

* index.php

```php
<?php
// import Html.php
include "Html.php";

// declare object from Html class Table() method
$table = new Html\Table();
$table->title = "My table";
$table->numRows = 5;

// declare object from Html class Row() method
$row = new Html\Row();
$row->numCells = 3;
?>

<html>
<body>

<?php $table->message(); ?>
<?php $row->message(); ?>

</body>
</html>
```

### PHP Iterator

* An iterator must have these methods:
  1. current() - Returns the element that the pointer is currently pointing to. It can be any data type
  2. key() Returns the key associated with the current element in the list. It can only be an integer, float, boolean or string
  3. next() Moves the pointer to the next element in the list
  4. rewind() Moves the pointer to the first element in the list
  5. valid() If the internal pointer is not pointing to any element (for example, if next() was called at the end of the list), this should return false. It returns true in any other case

```php
<!DOCTYPE html>
<html>
<body>

<?php
// Create an Iterator
class MyIterator implements Iterator {
  private $items = [];
  private $pointer = 0;

  public function __construct($items) {
    // array_values() makes sure that the keys are numbers
    $this->items = array_values($items);
  }

  public function current() {
    return $this->items[$this->pointer];
  }

  public function key() {
    return $this->pointer;
  }

  public function next() {
    $this->pointer++;
  }

  public function rewind() {
    $this->pointer = 0;
  }

  public function valid() {
    // count() indicates how many items are in the list
    return $this->pointer < count($this->items);
  }
}

// A function that uses iterables
function printIterable(iterable $myIterable) {
  foreach($myIterable as $item) {
    echo $item;
  }
}

// Use the iterator as an iterable
$iterator = new MyIterator(["a", "b", "c"]);
printIterable($iterator);
?>

</body>
</html>
```

## PHP + MySQL connect

### Simple PHP + MySQL connect

```php
/* Method 1 */
<?php
  define('DB_HOST', 'localhost');
  define('DB_USER', 'renfei');
  define('DB_PASS', 'root');
  define('DB_NAME', 'database_name');

  $dbc = mysqli_connect(DB_HOST, DB_USER, DB_PASS, DB_NAME);
  $query = "INSERT INTO table_name (column1, column2) VALUES ('value1', 'value2')";

  mysqli_query($dbc, $query);
?>

/* Method 2 */
<?php
  $dbc = mysqli_connect(DB_HOST, DB_USER, DB_PASS, DB_NAME);
  $query = "SELECT * FROM table_name WHERE problem_id='$id'";
  $result = mysqli_query($dbc, $query);
  $row = mysqli_fetch_array($result);
  $problem_title = $row['problem_title'];
?>

/* Method 3 */
/*
* Change the value of $password if you have set a password on the root userid
* Change NULL to port number to use DBMS other than the default using port 3306
*
*/
$user = 'root';
$password = ''; //To be completed if you have set a password to root
$database = ''; //To be completed to connect to a database. The database must exist.
$port = NULL; //Default must be NULL to use default port
$mysqli = new mysqli('127.0.0.1', $user, $password, $database, $port);

if ($mysqli->connect_error) {
    die('Connect Error (' . $mysqli->connect_errno . ') '
            . $mysqli->connect_error);
}
echo '<p>Connection OK '. $mysqli->host_info.'</p>';
echo '<p>Server '.$mysqli->server_info.'</p>';
$mysqli->close();
```

### MySQL ORDER BY

```php
<?php
  $dbhost = 'localhost';  // mysql服务器主机地址
  $dbuser = 'root';            // mysql用户名
  $dbpass = '123456';          // mysql用户名密码
  $conn = mysqli_connect($dbhost, $dbuser, $dbpass);
  if(! $conn ) {
    die('连接失败: ' . mysqli_error($conn));
  }
  // 设置编码，防止中文乱码
  mysqli_query($conn , "set names utf8");
  
  $sql = 'SELECT a.runoob_id, a.runoob_author, b.runoob_count FROM runoob_tbl a INNER JOIN tcount_tbl b ON a.runoob_author = b.runoob_author';
  
  mysqli_select_db( $conn, 'RUNOOB' );
  $retval = mysqli_query( $conn, $sql );
  if(! $retval ) {
    die('无法读取数据: ' . mysqli_error($conn));
  }
  echo '<h2>菜鸟教程 MySQL JOIN 测试<h2>';
  echo '<table border="1"><tr><td>教程 ID</td><td>作者</td><td>登陆次数</td></tr>';
  while($row = mysqli_fetch_array($retval, MYSQLI_ASSOC)) {
    echo "<tr><td> {$row['runoob_id']}</td> ".
        "<td>{$row['runoob_author']} </td> ".
        "<td>{$row['runoob_count']} </td> ".
        "</tr>";
  }
  echo '</table>';
  mysqli_close($conn);
?>
```

### PHP MySQL While

```php
<?php
  $dbc = mysqli_connect(DB_HOST, DB_USER, DB_PASS, DB_NAME);
  $query = "SELECT user_id FROM database_name ORDER BY user_id ASC";
  $result = mysqli_query($dbc, $query);

  while ($row = mysqli_fetch_array($result)) {
    $user_id = $row['user_id'];
    echo "<tr>";
    echo "<td>".$user_id."</td>";
    echo "</tr>";
  }
?>
```

### Getting data from HTML form

* HTML form

```html
<form method="post" action="<?php echo $_SERVER['PHP_SELF']; ?>">
  <label for="username">用户名:</label>
  <input type="text" id="username" name="username" /><br/>
  <label for="info">信息:</label>
  <input type="text" id="info" name="info" /><br/>

  <input type="submit" value="Submit" name="submit"/>
</form>
```

* PHP parse data into MySQL database

```php
<?php
  $dbc = mysqli_connect(DB_HOST, DB_USER, DB_PASS, DB_NAME);

  if (isset($_POST['submit'])) {
    $user = $_POST['username'];
    $info = $_POST['info'];
    $query = "INSERT INTO table_name (tb_user, tb_info) VALUES ('$user', '$info')";
    mysqli_query($dbc, $query);
    echo "<p>提交成功</p>";
  }
  mysqli_close($dbc);
?>

/* Form validation */
<?php
  if (!empty($user) && !empty($info)) {
    // 插入操作
  } else {
    echo "请填写全部内容后再提交";
  }
?>
```

### Writing a PHP form

1. Connection (connection.php)

```php
<?php  
       $servername = "localhost";  
       $username = "root";  
       $password = "";  
       $conn = mysql_connect ($servername , $username , $password) or die("unable to connect to host");  
       $sql = mysql_select_db ('test',$conn) or die("unable to connect to database"); 
?> 
```

2. Fetch data from database (modified.php) and output to the same php page

```php
<?php     
include "connection.php";    
    
if(isset($_GET['id'])) {    
  $sql = "delete from registration where id = '".$_GET['id']."'";    
  $result = mysql_query($sql);    
}    
  
$sql = "select * from registration";    
$result = mysql_query($sql);    
?>

<html>    
  <body>    
    <table width = "100%" border = "1" cellspacing = "1" cellpadding = "1">    
      <tr>    
        <td>Id</td>    
        <td>First Name</td>    
        <td>Middle Name</td>    
        <td>Last Name</td>    
        <td>Password</td>    
        <td>Confirm Password</td>    
        <td>Email</td>    
        <td>Contact No.</td>    
        <td>Gender</td>    
        <td>Address</td>    
        <td>Pincode</td>    
        <td>City</td>    
        <td>Country</td>    
        <td>Skills</td>    
        <td>Files</td>    
        <td colspan = "2">Action</td>    
      </tr>    
    </table>    
  </body>    
</html>  

  <?php
  while($row = mysql_fetch_object($result)) {
    <tr>  
      <td>  
        <?php echo $row->id;?>  
      </td>  
      <td>  
        <?php echo $row->fname;?>  
      </td>  
      <td>  
        <?php echo $row->mname;?>  
      </td>  
      <td>  
        <?php echo $row->lname;?>  
      </td>  
      <td>  
        <?php echo $row->pwd;?>  
      </td>  
      <td>  
        <?php echo $row->cnf;?>  
      </td>  
      <td>  
        <?php echo $row->mail;?>  
      </td>  
      <td>  
        <?php echo $row->number;?>  
      </td>  
      <td>G  
        <?php echo $row->sex;?>  
      </td>  
      <td>  
        <?php echo $row->address;?>  
      </td>  
      <td>  
        <?php echo $row->code;?>  
      </td>  
      <td>  
        <?php echo $row->city;?>  
      </td>  
      <td>  
        <?php echo $row->country;?>  
      </td>  
      <td>  
        <?php echo $row->skills;?>  
      </td>  
      <td>  
        <?php echo $row->attach_file;?>  
      </td>  
      <td> 
        <a href="listing.php?id = <?php echo $row->id;?>" onclick="return confirm('Are You Sure')">Delete</a> | <a href="index.php?id = <?php echo $row->id;?>" onclick="return confirm('Are You Sure')">Edit</a> 
      </td>  
    </tr>  } 
  ?>
?>  
```

### PHP GET and POST form method

* POST method

1. sender.html

```html
<html>
<body>
  <p>Please enter the following values:</p>
  <form action="receiver.php" method="post">
    <br />First Name: <input type="text" name="firstName" value="John">
    <p>Last Name: <input type="text" name="lastName"></p>
    <p>Like Cake? <input type="checkbox" name="cake" value="yes"></p>
    <p>Select the type of cake you like:
      <br /><input type="radio" name="cakeflavor" value="chocolate">Chocolate
      <br /><input type="radio" name="cakeflavor" value="vanilla">Vanilla
      <br /><input type="radio" name="cakeflavor" value="beer">Beer
    </p>
    <p><input type="reset"></p>
    <input type="submit" value="Submit">
  </form>
</body>
</html>
```

2. receiver.php

```php
<?php
  //This is the collection of variables we are catching from POST
  $firstName = '';
  $lastName = '';
  $cake = false;
  $cakeFlavor = false;
  //Tracking if there are any errors that have arrived.
  $errors = false;

  //The user's entered first name
  if(!isset($_POST['firstName']) || empty($_POST['firstName'])) {
    echo "<p>First name is missing.</p>";
    $errors = true;
  } else {
    $firstName = $_POST['firstName'];
  }

  //The user's entered last name
  if(!isset($_POST['lastName']) || empty($_POST['lastName'])) {
    echo "<p>Last name is missing.</p>";
    $errors = true;
  } else {
    $lastName = $_POST['lastName'];
  }

  //Do they like cake is checked or not
  if(!isset($_POST['cake']) || empty($_POST['cake'])) {
    $cake = false;
  } else {
    $cake = true;
  }

  //What flavor cake did they pick?
  if(!isset($_POST['cakeFlavor']) || empty($_POST['cakeFlavor'])) {
    $cakeFlavor = false;
  } else {
    $cakeFlavor = $_POST['cakeFlavor'];
  }

  if(!$errors) {
    echo "<p>First Name: $firstName</p>";
    echo "<p>Last Name: $lastName</p>";
    //if they checked cake, and selected a cake flavor:
    if($cake == true && $cakeFlavor != false) {
      echo "<p>I shall make you a $cakeFlavor cake!</p>";
    } else {
      echo "<p>Perhaps you would prefer pie?</p>";
    }
  }
?>
```

### Prevent MySQL from external attacks

```php
<?php
  $user = mysqli_real_escape_string($dbc, trim($_POST['username']));
  $info = mysqli_real_escape_string($dbc, trim($_POST['info']));
?>
```

### 粘性表单

* 如果用户第一次填写失败，他们希望能保留已经填写好的内容，只做些修改就好了。这需要使用粘性表单技术。要实现，只需要稍稍改动 HTML 表单部分的代码：

```html
<label for="username">用户名:</label>
<input type="text" id="username" name="user" value="<?php if (!empty($user)) echo $user; ?>" >
```

### 检查用户是否重复

```php
<?php  
  $dbc = mysqli_connect(DB_HOST, DB_USER, DB_PASS, DB_NAME);    
  $query = "SELECT * FROM table_name WHERE user_name = '$user'";
  $data = mysqli_query($dbc, $query);
  if (mysqli_num_rows($data) == 0) {
    // 把内容插入数据库
    echo "注册成功";
    mysqli_close($dbc);
    exit();
  } else {
    echo "用户名已被占用，请重新选择用户名";
    $user = "";
  }
?>
```

### 对密码进行加密存储

* keyword use for PHP (sha = secure hash algorithm)

```php
sha1($password)
```

### PHP + MySQL Food Delivering System Example

* sql-parse.php file

```php
<?php 
define ('DB_HOST', 'localhost:8000');
define ('DB_USER', 'root');
define ('DB_PASS', '123456');
define ('DB_NAME', 'order_information');

$dbc = mysqli_connect(DB_HOST, DB_USER, DB_PASS, DB_NAME);
if(!$dbc) {
  die("Connection failed: " . mysqli_connect_error());
}
echo "Connected successfully";

date_default_timezone_set('Asia/Kuala_Lumpur');
$custName = $_POST['cust_name'];
$custAddr = $_POST['cust_addr'];
$custPhone = $_POST['cust_phone'];
$custEmail = $_POST['cust_email'];
$foodName = $_POST['food_name'];
$orderDate = date('Y-m-d H:i:s');
$foodQty = $_POST['order_qty'];
$addRequest = $_POST['extra_request'];
for($i=0; $i<sizeof($foodName);$i++) {

  echo "$custName" . "<br>" . "$custAddr" . "<br>" . "$custPhone" . "<br>" . "$custEmail" . "<br>" . "$foodName[$i]" . "<br>" . "$orderDate" . "<br>" . "$foodQty" . "<br>" . "$addRequest";
  $query = "INSERT INTO orderlist(OrderDate, OrderQty, FoodID, CustID, OrderAmount, AdditionalRequest) 
  VALUES('$orderDate',
  '$foodQty', 
  (SELECT FoodID FROM food WHERE FoodName = '$foodName[$i]'), 
  (SELECT CustID from customer
  WHERE CustName='$custName' AND CustAddress='$custAddr' AND CustPhone='$custPhone' AND CustEmail='$custEmail'),
  ((SELECT FoodPrice FROM food WHERE FoodName = '$foodName[$i]') * OrderQty), '$addRequest')";
if(mysqli_query($dbc, $query)) {
  echo"updated succefully.";
} else {
  echo "Error: " . $dbc . "<br>" . mysqli_error($query);
}
}
mysqli_close($dbc);
echo '<script>alert("Order Submitted. Thank you for buying with us.")</script>';
?>



/* 
php and mysql error troubleshoot 
1. php with mysql 8.0+ error: the server requested authentication method unknown to the client
(password authentication issue for mysql(for mysql8.0++, password authentication has changed to sha246_password))
  !! Solution:
      a. login as root to mysql
      b. run sql command to change password authentication plugin:
      ALTER USER 'root' @ 'localhost' IDENTIFIED WITH mysql_native_password BY 'existing password';


2. do not mix up MySQLi OOP, MySQLi Procedural and PDO command, will throw many error and cannot read the data correctly.
*/
```

* html form

```html
<!DOCTYPE html>
<html>
  <head>
    <title>Food Deliver System</title>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, height=device-height, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
  </head>
  <body>
    <div class="container">
      <h1 class="text-center">Food Deliver System</h1>
      <form action="sql-parse.php" method="POST">
        <div class="row">
          <div class="col-3">
            <label class="form-label">Name: </label>  
          </div>
          <div class="col-6">
            <input type="text" class="form-control" id="cust_name" name="cust_name" required>
          </div>   
        </div>
      </br>
        <div class="row">
          <div class="col-3">
            <label>Address: </label> 
          </div>
          <div class="col-6">
            <textarea class="form-control" rows="3" id="cust_addr" name="cust_addr" required></textarea>
          </div>   
        </div>
      </br>
      <div class="row">
        <div class="col-3">
          <label class="form-label">Phone Number: </label>  
        </div>
        <div class="col-6">
          <input type="text" class="form-control" id="cust_phone" name="cust_phone" placeholder="012-2345678" required>
        </div>   
      </div>
    </br>
    <div class="row">
      <div class="col-3">
        <label class="form-label">Email: </label>  
      </div>
      <div class="col-6">
        <input type="email" class="form-control" id="cust_email" name="cust_email" placeholder="email@example.com" required>
      </div>   
    </div>
  </br>
  <div class="row">
    <div class="col-3">
      <label class="form-label">Food: </label>  
    </div>
    <div class="col-4">
      <div class="form-check">
        <input class="form-check-input" type="checkbox"  id="food_name" name="food_name[]" value="Beef Steak">
        <label class="form-check-label" for="flexCheckDefault">Beef Steak</label>
      </div>
      <div class="form-check">
        <input class="form-check-input" type="checkbox"  id="food_name" name="food_name[]" value="Curry Chicken">
        <label class="form-check-label" for="flexCheckDefault">Curry Chicken</label>
      </div>
      <div class="form-check">
        <input class="form-check-input" type="checkbox"  id="food_name" name="food_name[]" value="Kangkung Goreng Sambal Belacan">
        <label class="form-check-label" for="flexCheckDefault">Kangkung Goreng Sambal Belacan</label>
      </div>
      <div class="form-check">
        <input class="form-check-input" type="checkbox"  id="food_name" name="food_name[]" value="Salad">
        <label class="form-check-label" for="flexCheckDefault">Salad</label>
      </div>
      <div class="form-check">
        <input class="form-check-input" type="checkbox"  id="food_name" name="food_name[]" value="Thai Fried Rice">
        <label class="form-check-label" for="flexCheckDefault">Thai Fried Rice</label>
      </div>
    </div>
    <div class="col-4">
      <div class="form-check">
        <input class="form-check-input" type="checkbox"  id="food_name" name="food_name[]" value="Tom Yum Soup">
        <label class="form-check-label" for="flexCheckDefault">Tom Yum Soup</label>
      </div>
      <div class="form-check">
        <input class="form-check-input" type="checkbox"  id="food_name" name="food_name[]" value="Chicken Dumpling">
        <label class="form-check-label" for="flexCheckDefault">Chicken Dumpling</label>
      </div>
      <div class="form-check">
        <input class="form-check-input" type="checkbox"  id="food_name" name="food_name[]" value="Fish Ball Soup">
        <label class="form-check-label" for="flexCheckDefault">Fish Ball Soup</label>
      </div>
      <div class="form-check">
        <input class="form-check-input" type="checkbox"  id="food_name" name="food_name[]" value="Nasi Goreng Kampung">
        <label class="form-check-label" for="flexCheckDefault">Nasi Goreng Kampung</label>
      </div>
      <div class="form-check">
        <input class="form-check-input" type="checkbox"  id="food_name" name="food_name[]" value="Chicken Rice">
        <label class="form-check-label" for="flexCheckDefault">Chicken Rice</label>
      </div>
    </div>   
  </div>
</br>
<div class="row">
  <div class="col-3">
    <label class="form-label">Quantity: </label>  
  </div>
  <div class="col-6">
    <input type="text" class="form-control" id="order_qty" name="order_qty" required>
  </div>   
</div>
</br>
<div class="row">
  <div class="col-3">
    <label class="form-label">Additional Request: </label>  
  </div>
  <div class="col-6">
    <textarea class="form-control" rows="3" id="extra_Request" name="extra_Request"></textarea>
  </div>   
</div>
</br>
<div class="row">
  <div class="col-4"></div>
  <div class="col-4">
    <input class="btn btn-primary btn-lg" type="submit" id="submit" name="submit" value="Submit">
    <input class="btn btn-light btn-lg" type="reset" value="Reset">
  </div>
  <div class="col-4"></div>
</div>
</br> 
      </form>
    </div>
  </body>
</html>
```
