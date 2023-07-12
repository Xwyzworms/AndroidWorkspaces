part of 'advisor_bloc.dart';

@immutable
abstract class AdvisorState extends Equatable {
  @override
  List<Object?> get props => [];
}

class AdvisorInitial extends AdvisorState {}

class AdvisorStateLoading extends AdvisorState {}

class AdvisorStateLoaded extends AdvisorState {
  final String advice;
  AdvisorStateLoaded({required this.advice});
}

class AdvisorStateError extends AdvisorState {
  final String errorMessage;
  AdvisorStateError({required this.errorMessage});
}