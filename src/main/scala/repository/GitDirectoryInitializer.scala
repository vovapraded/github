package repository

import commit.CommitCreator
import console.MyConsole
import constant.Constants

import java.nio.file.{Files, Paths, StandardCopyOption}

object GitDirectoryInitializer {


  def initGitDirectory(): Unit = {

    GitDirectoryCreator.createGitDirectory(Constants.myGitDir)  match {
      case Right(_) =>
        MyConsole.println(s"Директория .myGit успешно создана")
        CommitCreator.createCommit("init")
      // Дальше делаем что-то с коммитом
      case Left(errorMessage) =>
        MyConsole.println(s"$errorMessage")
      // Дополнительная обработка ошибки
    }
  }
}