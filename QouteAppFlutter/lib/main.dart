import 'package:flutter/material.dart';
import 'package:provider/provider.dart';
import 'package:qoute_app_flutter/application/core/services/themeService.dart';
import 'package:qoute_app_flutter/theme.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({Key? key}) : super(key : key);
  @override
  Widget build(BuildContext context) {
    return Consumer<ThemeService>(builder : (context, themeService, child) {
      return MaterialApp(
        themeMode: themeService.isDarkModeOn ? ThemeMode.dark : ThemeMode.light,
        theme : AppTheme.lightTheme,
        darkTheme: AppTheme.darkTheme,
        home : const Placeholder()
      );
    });
  }

}

