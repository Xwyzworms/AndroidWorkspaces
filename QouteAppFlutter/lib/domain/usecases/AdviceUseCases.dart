
import 'package:dartz/dartz.dart';
import 'package:qoute_app_flutter/data/repositories/AdviceRepoImpl.dart';
import 'package:qoute_app_flutter/domain/failures/Failure.dart';
import 'package:qoute_app_flutter/domain/repositories/AdviceRepo.dart';

import '../entities/AdviceEntity.dart';

class AdviceUseCases {
    final AdviceRepo adviceRepoImpl = AdviceRepoImpl();

    Future<Either<Failure,AdviceEntity>> getAdvice() async {
      return adviceRepoImpl.getAdviceFromRemoteSource();

    }
}