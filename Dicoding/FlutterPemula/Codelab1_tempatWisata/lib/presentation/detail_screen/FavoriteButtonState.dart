import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

import 'FavoriteButton.dart';

class FavoriteButtonState extends State<FavoriteButton> {
  bool isFavorite = false;
  @override
  Widget build(BuildContext context) {
    return IconButton(onPressed: () {
      setState(() {
        isFavorite = !isFavorite;
      });
    }, icon:Icon(isFavorite ? Icons.favorite : Icons.favorite_border));
  }


}