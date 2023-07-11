
import 'package:flutter/cupertino.dart';

class ThemeService extends ChangeNotifier {
  bool isDarkModeOn = false;

  void toggleTheme() {
    isDarkModeOn = !isDarkModeOn;
    notifyListeners();
  }
}