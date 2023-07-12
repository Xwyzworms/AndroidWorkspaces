
import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:provider/provider.dart';
import 'package:qoute_app_flutter/application/core/services/themeService.dart';
import 'package:qoute_app_flutter/application/pages/advice/widgets/advicerField.dart';
import 'package:qoute_app_flutter/application/pages/advice/widgets/customButton.dart';
import 'package:qoute_app_flutter/application/pages/advice/widgets/errorMessage.dart';

import 'bloc/advisor_bloc.dart';

class AdvisorPageBlocWrapperProvider extends StatelessWidget {
  const AdvisorPageBlocWrapperProvider({super.key});

  @override
  Widget build(BuildContext context)
  {
    return BlocProvider(
        create : (context) => AdvisorBloc(),
        child : const AdvisorPage()
    );
  }

}

class AdvisorPage extends StatelessWidget {
  const AdvisorPage({super.key});

  @override
  Widget build(BuildContext context)
  {
    final themeData = Theme.of(context);
    return Scaffold(
      appBar : AppBar(
        title : Text("Advicer", style : themeData.textTheme.headlineLarge ),
        centerTitle: true,
        actions : [
          Switch(value: Provider.of<ThemeService>(context).isDarkModeOn, onChanged: (_) {
            Provider.of<ThemeService>(context, listen: false).toggleTheme();
          })
        ],
      ),
      body: Padding(padding : const EdgeInsets.symmetric(horizontal: 50) ,
        child: Column(
          children: [
            Expanded(
                child : Center(child: BlocBuilder<AdvisorBloc, AdvisorState>(builder: (context, state) {
                  if(state is AdvisorInitial)
                  {
                    return Text("Waiting for new advice", style : themeData.textTheme.headlineLarge);
                  }
                  else if(state is AdvisorStateLoading)
                  {
                    return CircularProgressIndicator(color : themeData.colorScheme.secondary);
                  }
                  else if (state is AdvisorStateLoaded)
                  {
                    return AdvicerField(advice: state.advice);
                  }
                  else if(state is AdvisorStateError) {
                    return ErrorMessage(message : state.errorMessage);
                  }
                  return const SizedBox();
                }),
                )
            ),
            const SizedBox(height : 200, child : Center(child : CustomButton()))
          ],
        ),
      ),
    );
  }
}
