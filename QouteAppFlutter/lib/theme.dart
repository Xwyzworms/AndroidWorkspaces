
import 'package:flutter/material.dart';

class AppTheme {
  AppTheme._(); // Private Constructor ( Sorry new person )
  // ********
    // Static Colors
  // *****

  static final Color _lightPrimaryColor = Colors.blueGrey.shade50;
  static final Color _lightPrimaryVariantColor = Colors.blueGrey.shade800;
  static final Color _lightOnPrimaryColor = Colors.blueGrey.shade200;
  static const Color _lightTextColorPrimary = Colors.black;
  static const Color _appBarColorLight = Colors.blue;

  static final Color _darkPrimaryColor = Colors.blueGrey.shade900;
  static const Color _darkPrimaryVariantColor = Colors.black;
  static final Color _darkOnPrimaryColor = Colors.blueGrey.shade300;
  static const Color _darkTextColorPrimary = Colors.white;
  static final Color _appBarColorDark = Colors.blueGrey.shade800;

  static const Color _iconColor  = Colors.white;

  static const Color _accentColor = Color.fromRGBO(74, 217, 217, 1);

// ******
  // Text Style
//

static const TextStyle _lightHeadingText = TextStyle(
    color : _lightTextColorPrimary,
    fontFamily : "Rubik",
    fontSize : 20,
    fontWeight : FontWeight.bold
);


static const TextStyle _lightBodyText = TextStyle(
  color : _lightTextColorPrimary,
  fontFamily: "Rubik",
  fontSize : 20,
  fontWeight : FontWeight.bold
);

static const TextTheme _lightTextTheme = TextTheme(

  displayLarge: _lightHeadingText,
  bodyLarge: _lightBodyText
);

//
// Text Style Dark
//
static final TextStyle _darkThemeHeadingTextStyle = TextStyle(
  color : _darkPrimaryColor,
  fontFamily: "Rubik",
  fontSize : 20,
  fontWeight : FontWeight.bold
);

static final TextStyle _darkThemeBodyTextStyle = TextStyle(
  color : _darkPrimaryColor,
  fontFamily: "Rubik",
  fontSize : 20,
  fontWeight : FontWeight.bold
);

static final TextTheme _darkTextTheme = TextTheme(
  displayLarge: _darkThemeHeadingTextStyle,
  bodyLarge:_darkThemeBodyTextStyle
);

// Theme light/dark

static final ThemeData lightTheme = ThemeData(
  scaffoldBackgroundColor: _lightPrimaryColor,
  appBarTheme: const AppBarTheme(
      color : _appBarColorLight,
      iconTheme: IconThemeData(color : _iconColor)
  ),bottomAppBarTheme: const BottomAppBarTheme(color : _appBarColorLight),
   colorScheme: ColorScheme.light(
      primary : _lightPrimaryColor,
     onPrimary: _lightOnPrimaryColor,
     secondary: _accentColor,
     primaryContainer: _lightPrimaryVariantColor
   ),
  textTheme : _lightTextTheme
);


static final ThemeData darkTheme = ThemeData(
  scaffoldBackgroundColor: _darkPrimaryColor,
  appBarTheme: AppBarTheme(
    color : _appBarColorDark,
    iconTheme :  const IconThemeData(color : _iconColor),
  ),
  bottomAppBarTheme: const BottomAppBarTheme(color : _appBarColorLight),
  colorScheme: ColorScheme.dark(
    primary : _darkPrimaryColor,
    onPrimary: _darkOnPrimaryColor,
    secondary : _accentColor,
    primaryContainer: _darkPrimaryVariantColor
  ),
  textTheme : _darkTextTheme
);




}


