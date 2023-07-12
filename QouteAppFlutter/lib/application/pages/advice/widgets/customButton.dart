

import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:qoute_app_flutter/application/pages/advice/bloc/advisor_bloc.dart';

class CustomButton extends StatelessWidget {
  const CustomButton({super.key});

  @override
  Widget build(BuildContext context)
  {
    final themeData = Theme.of(context);
    return InkResponse(
        onTap:(){
          BlocProvider.of<AdvisorBloc>(context).add(AdviceRequestEvent());
        },
        child : Material(
            elevation: 20,
            borderRadius: BorderRadius.circular(15),
            child : Container(
                decoration: BoxDecoration(
                    borderRadius:  BorderRadius.circular(15),
                    color : themeData.colorScheme.secondary
                ),
                child : Padding(
                    padding : const  EdgeInsets.symmetric(horizontal: 10, vertical: 15),
                    child : Text("Get live", style : themeData.textTheme.bodyLarge))
            )
        )
    );
  }
}