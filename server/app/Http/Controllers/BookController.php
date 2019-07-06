<?php

namespace App\Http\Controllers;

use App\book;
use Illuminate\Http\Request;

class BookController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $books = book::all();
        return view('books.list' , ['list' => $books]);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()

    {
        return view("books.create");
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        $book = new Book();
        $book->name = $request->get('name');

        $book->writer = $request->get('writer');
        $book->pagecount = $request->get('pagecount');
        $book->printyear = $request->get('printyear');
        $book->category_id = $request->get('category_id');

        $book->save();

        if ($request->hasFile('picture')) {
            $request->file('picture')->storeAs('logos' , $book->id . '.' .$request->picture->getClientOriginalExtension());
        }

        $book->picture = $book->id . '.' .$request->picture->getClientOriginalExtension();
        $book->save();

        return redirect()->route('bookList');
    }

    /**
     * Display the specified resource.
     *
     * @param  \App\book  $book
     * @return \Illuminate\Http\Response
     */
    public function show(book $book)
    {
        //
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  \App\book  $book
     * @return \Illuminate\Http\Response
     */
    public function edit(book $book)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\book  $book
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, book $book)
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param $id
     * @return \Illuminate\Http\Response
     */
    public function destroy( $id)
    {
        book::destroy($id);
        return redirect()-> route('bookList');
    }
}
