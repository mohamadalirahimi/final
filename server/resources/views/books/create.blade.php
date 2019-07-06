<html>
<head>
    <link rel="stylesheet" href="{{ URL::asset('css/app.css') }}">
    <link rel="stylesheet" href="{{ URL::asset('css/adminlte.css') }}">

    <link rel="stylesheet" href="{{ URL::asset('css/bootstrap-rtl.min.css') }}">
    <link rel="stylesheet" href="{{ URL::asset('css/custom-style.css') }}">
    <link rel="stylesheet" href="{{ URL::asset('css/style.css') }}">
    <link rel="stylesheet" href="{{ URL::asset('css/persian-datepicker.min.css') }}">
    <link rel="stylesheet" href="{{ URL::asset('css/fontawesome.min.css') }}">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col">
            <div class="card min-h-400">
                <div class="card-header text-center">
                    ثبت کتاب ها

                </div>
                <form enctype="multipart/form-data" method="post" action="/books">
                    {{csrf_field()}}

                    <span class="form-control1">نام کتاب : </span>
                    <input class="form-control" type="text" name="name"
                           placeholder=" نام کتاب را وارد کنید:"
                    >



                    <span class="form-control1">نام نویسنده : </span>
                    <input class="form-control" type="text" name="writer"
                           placeholder=" نام نویسنده را وارد کنید:"
                    >
                    <span  class="form-control1">موضوع اصلی: </span>
                    <select  class="form-control1" name="category_id">
                       @php $res = \App\recommendations::all() @endphp
                     @foreach($res as $re)
                         <option value="{{$re->id}}">{{$re->title}}</option>
                         @endforeach
                    </select>


                    <span class="form-control1">تعداد صفحات : </span>
                    <input class="form-control" type="number" name="pagecount"
                           placeholder="تعداد را وارد کنید:"
                    >


                    <span class="form-control1">سال چاپ : </span>
                    <input class="form-control min-vw-100" type="number" name="printyear"
                           placeholder="سال چاپ را وارد کنید:"
                    >

                    <span class="form-control1">تصویر : </span>
                    <input class="form-control1" type="file" name="picture"
                           placeholder=" عکس :"/>


                    <div class="input-group-append">
                        <button style="display: block;margin: 0 auto;width: 188px;background: darkgreen;"
                                class="btn btn-primary" type="submit"
                                id="button-addon2">ثبت
                        </button>
                    </div>


                </form>


            </div>
        </div>
    </div>
</div>
</body>
</html>