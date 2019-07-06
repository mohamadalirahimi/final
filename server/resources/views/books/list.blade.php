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
                    لیست کتاب ها

                </div>
                <div class="list-root">
                    <table class="table table-bordered table-responsive-md">
                        <tbody>
                        <thead class="thead-dark">
                        <tr>

                            <th scope="row">کد کتاب </th>
                            <th>تصویر</th>
                            <th>نام کتاب </th>
                            <th>نویسنده</th>
                            <th>موضوع اصلی</th>
                            <th>تعداد صفحات </th>
                            <th>سال چاپ </th>
                            <th class="table-buttons">
                                عملیات
                            </th>
                        </tr>

                        </thead>
                        @foreach($list as $book)



                            <tr>
                                <td>{{$book->id}}</td>
                                <td><img width="100px" src="{{asset('logos') . '/' . $book->picture}}"/></td>
                                <td>{{$book->name}}</td>
                                <td>{{$book->writer}}</td>
                                <td>{{$book->category->title}}</td>
                                <td>{{$book->pagecount}}</td>
                                <td>{{$book->printyear}}</td>

                                <td><a href="/books/delete/{{$book->id}}">
                                        <button class="btn btn-sm btn-danger">حذف</button>
                                    </a></td>
                            </tr>




                        @endforeach
                    </table>
                    <a href="/books/create" ><div class="input-group-append">
                        <button style="display: block;margin: 0 auto;width: 188px;background: darkgreen;"
                                class="btn btn-primary" type="submit"
                                id="button-addon2">افزودن کتاب
                        </button>
                    </div></a>

                </div>


            </div>
        </div>
    </div>
</div>
</body>
</html>