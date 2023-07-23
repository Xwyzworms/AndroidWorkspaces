import 'package:flutter/material.dart';
import 'package:news_app/DetailPage.dart';
import 'package:news_app/NewsListPage.dart';
import 'package:news_app/article_webview.dart';

import 'article.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context)
  {
    return MaterialApp(
      title : "News App",
      theme: ThemeData(
          primarySwatch: Colors.blue,
          visualDensity: VisualDensity.adaptivePlatformDensity
      ),
      initialRoute: NewsListPage.routeName,
      routes:  {
        NewsListPage.routeName: (context) =>  NewsListPage(),
        DetailPage.routeName : (context) => DetailPage(article:
        ModalRoute.of(context)?.settings.arguments as Article
        ),
        ArticleWebView.routeName : (context) => ArticleWebView(url:
            ModalRoute.of(context)?.settings.arguments as String
        )

      },
    );
  }
}
