-using MVVM as architecture design pattern
-apply SOLID principles(Single responsability and open-close)
-appling clean code archtichre(Separation between layers and divide them into [view-viewmodel-dispatcher-repository-model-cross cutting utils]) with generic (error handling, parsing models)
-using view binding
-using kotlin and coroutine
-using dependency injection 
-app using cashing if no internet connection


App Scenarios
1- open app fot the first time with no internet connection, you will get an error with try again
2- open app with internet connection, app will opened normaly
3- open app with no internet connection but not the first time, app will retrieve data from cache