

import 'package:dartz/dartz.dart';
import 'package:flutter/cupertino.dart';
import 'package:qoute_app_flutter/data/datasources/AdviceRemoteDatasource.dart';
import 'package:qoute_app_flutter/data/datasources/AdviceRemoteDatasourceImpl.dart';
import 'package:qoute_app_flutter/domain/entities/AdviceEntity.dart';
import 'package:qoute_app_flutter/domain/failures/CacheFailure.dart';
import 'package:qoute_app_flutter/domain/failures/Failure.dart';
import 'package:qoute_app_flutter/domain/failures/ServerFailure.dart';
import 'package:qoute_app_flutter/domain/repositories/AdviceRepo.dart';

class AdviceRepoImpl extends AdviceRepo {

  final AdviceRemoteDatasource adviceRemoteDataSource = AdviceRemoteDatasourceImpl();

  @override
  Future<Either<Failure, AdviceEntity>> getAdviceFromRemoteSource() async {
      try {
        final result = await adviceRemoteDataSource.getRandomAdviceFromApi();
        debugPrint("Hi" + result.toString());
        return right(result);
      } on ServerFailure catch(_)
      {
        return left(ServerFailure());
      }
      catch(e) {
        return left(CacheFailure());
      }
  }

}