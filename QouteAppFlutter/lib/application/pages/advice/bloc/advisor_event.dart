part of 'advisor_bloc.dart';


@immutable
abstract class AdvisorEvent extends Equatable {

  @override
  List<Object?> get props => [];
}

class AdviceRequestEvent extends AdvisorEvent {}