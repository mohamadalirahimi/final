<?php

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

Route::get('/', function () {
    return view('welcome');
});

Route::post('books', 'BookController@store');
Route::get('books/create' , 'BookController@create' );
Route::get('books' , 'BookController@index' )->name('bookList');
Route::get('books/delete/{id}' , 'BookController@destroy' );


Route::post('recommendations', 'RecommendationsController@store');
Route::get('recommendations/create' , 'RecommendationsController@create' )->name('createCategory');
Route::get('recommendations/delete/{id}' , 'RecommendationsController@destroy' );

