<?php

namespace App\Http\Controllers;

use App\recommendations;
use Illuminate\Http\Request;

class RecommendationsController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
    }

    /**
     * Show the form for creating a new resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function create()
    {
        return view("recommendations.create");

    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        $recommendations = new recommendations;



        $recommendations->title= $request->get('title');


        $recommendations->save();

        return redirect()->route('createCategory');
}

    /**
     * Display the specified resource.
     *
     * @param  \App\recommendations  $recommendations
     * @return \Illuminate\Http\Response
     */
    public function show(recommendations $recommendations)
    {
        //
    }

    /**
     * Show the form for editing the specified resource.
     *
     * @param  \App\recommendations  $recommendations
     * @return \Illuminate\Http\Response
     */
    public function edit(recommendations $recommendations)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\recommendations  $recommendations
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, recommendations $recommendations)
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\recommendations  $recommendations
     * @return \Illuminate\Http\Response
     */
    public function destroy($id)
    {
        recommendations::destroy($id);
        return redirect()-> route('createCategory');
    }
}
