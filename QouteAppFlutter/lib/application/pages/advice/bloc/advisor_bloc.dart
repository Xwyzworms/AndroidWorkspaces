

import 'package:equatable/equatable.dart';
import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';

part "advisor_event.dart";
part "advisor_state.dart";

class AdvisorBloc extends Bloc<AdvisorEvent, AdvisorState>{
  AdvisorBloc() : super(AdvisorInitial()) {
  on<AdviceRequestEvent>((event, emit) async{
    emit(AdvisorStateLoading());
    debugPrint("Advisor State Loading");
    await Future.delayed( const Duration(seconds: 3));
    debugPrint("Got Advice");
    emit(AdvisorStateLoaded(advice: "Hi Bitch"));
  });
  }
}