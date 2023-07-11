
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class AdvicerField extends StatelessWidget {
  final String advice;
  const AdvicerField({super.key, required this.advice});

  @override
  Widget build(BuildContext context)
  {
    final themeData = Theme.of(context);
    return Material(
        elevation : 20,
        borderRadius: BorderRadius.circular(15),
        child : Container(
            decoration : BoxDecoration(
              borderRadius: BorderRadius.circular(15),
              color : themeData.colorScheme.onPrimary,
            ),
            child : Padding(padding : const EdgeInsets.symmetric(horizontal: 15, vertical: 20),
              child: Text('''"$advice"''',
                style: themeData.textTheme.bodyLarge,
                textAlign: TextAlign.center,
              ),)
        )
    );
  }


}