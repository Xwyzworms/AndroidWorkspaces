

import 'package:dartz/dartz.dart';

import '../entities/AdviceEntity.dart';
import '../failures/Failure.dart';

abstract class AdviceRepo {

  Future<Either<Failure, AdviceEntity>> getAdviceFromRemoteSource();
}