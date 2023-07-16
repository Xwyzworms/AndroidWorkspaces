

import 'package:dartz/dartz.dart';
import 'package:equatable/equatable.dart';
import 'package:flutter/material.dart';
import 'package:flutter_bloc/flutter_bloc.dart';
import 'package:qoute_app_flutter/domain/entities/AdviceEntity.dart';
import 'package:qoute_app_flutter/domain/failures/ServerFailure.dart';
import 'package:qoute_app_flutter/domain/usecases/AdviceUseCases.dart';

import '../../../../domain/failures/Failure.dart';

part "advisor_event.dart";
part "advisor_state.dart";

class AdvisorBloc extends Bloc<AdvisorEvent, AdvisorState>{

  final String serverMessageFailure = "Api Error bro";
  final String cacheMessageFailur = "Cache Error bro";

  AdvisorBloc() : super(AdvisorInitial()) {
    final AdviceUseCases advisorUseCases = AdviceUseCases();
    on<AdviceRequestEvent>((event, emit) async{
      emit(AdvisorStateLoading());
      final Either<Failure,AdviceEntity> adviceResult = await advisorUseCases.getAdvice();
      adviceResult.fold(
              (failure)=> emit(AdvisorStateError( errorMessage : _mapFailure(failure))),
      (advice)=>  emit(AdvisorStateLoaded(advice: advice.advice)));
  });
}

String _mapFailure(failure)
{
  switch(failure.runtimeType) {
    case ServerFailure:
      return serverMessageFailure;
    default :
      return cacheMessageFailur;
  }
}
}