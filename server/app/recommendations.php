<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class recommendations extends Model
{
    public function books()
    {
        return $this->hasMany('App\book');
    }
}
