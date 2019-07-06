<?php

namespace App\Http\Controllers;

use App\bestbooks;
use Illuminate\Http\Request;

class BestbooksController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $bestbooks =bestbook::all();
        return response()->json($bestbooks, 200);
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        //
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        $bestbook = new Bestbook();


        $bestbook->name = $request->get('name');
        $bestbook->writer = $request->get('writer');
        $bestbook->pagecount = $request->get('pagecount');
        $bestbook->printyear = $request->get('print year');

        $bestbook->save();
        return response()->json($bestbook, 200);
    }

    /**
     * Display the specified resource.
     *
     * @param  \App\bestbooks  $bestbooks
     * @return \Illuminate\Http\Response
     */
    public function show(bestbooks $bestbooks)
    {
        //
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  \App\bestbooks  $bestbooks
     * @return \Illuminate\Http\Response
     */
    public function edit(bestbooks $bestbooks)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\bestbooks  $bestbooks
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, bestbooks $bestbooks)
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\bestbooks  $bestbooks
     * @return \Illuminate\Http\Response
     */
    public function destroy(bestbooks $bestbooks)
    {
        //
    }
}
