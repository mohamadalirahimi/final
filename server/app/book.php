<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class book extends Model
{
    public function category()
    {
        return $this->belongsTo('App\recommendations','category_id');
    }

    public function account()
    {
        return $this->belongsTo('App\account');
    }
}
