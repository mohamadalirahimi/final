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
                    دسته بندی کتاب ها

                </div>
                <form method="post" action="/recommendations">
                    {{csrf_field()}}

                    <span class="form-control1">موضوع اصلی : </span>
                    <input class="form-control" type="text" name="title"
                           placeholder=" موضوع کتاب را وارد کنید:"
                    >




                    <div class="input-group-append">
                        <button style="display: block;margin: 0 auto;width: 188px;background: darkgreen;"
                                class="btn btn-primary" type="submit"
                                id="button-addon2">ثبت
                        </button>
                    </div>


                </form>

                <br>
                <br>
                <div class="card-header text-center">
                    لیست موضوعات

                </div>
                <div class="list-root">
                    <table class="table table-bordered table-responsive-md">
                        <tbody>
                        <thead class="thead-dark">
                        <tr>

                            <th scope="row">کد دسته بندی </th>
                            <th> موضوعات</th>
                            <th class="table-buttons">
                                عملیات
                            </th>
                        </tr>

                        </thead>
                        @php $list=\App\recommendations::all()  @endphp
                        @foreach($list as $recommendations)



                            <tr>
                                <td>{{$recommendations->id}}</td>

                                <td>{{$recommendations->title}}</td>

                                <td><a href="/recommendations/delete/{{$recommendations->id}}">
                                        <button class="btn btn-sm btn-danger">حذف</button>
                                    </a></td>
                            </tr>




                        @endforeach
                    </table>


            </div>
        </div>
    </div>
</div>
</div>
</body>
</html>