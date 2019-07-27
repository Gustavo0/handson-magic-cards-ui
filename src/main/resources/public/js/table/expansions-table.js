$(document).ready(function() {
    $('.dataTable').DataTable( {
        "bFilter":false,
        "processing": true,
        "serverSide": true,
        "ajax": "/expansions/data",
        "columns": [
            {"data":"expansionId"},
            {"data":"name"},
            {"data":"ptBrName"},
            {
                "data": null,
                "render": function (data, type, row, meta) {
                    return '<a href="/cards/expansions/update/' + row['expansionId'] + '" class="editor_edit">Edit</a> | <a href="/cards/expansions/delete/' + row['expansionId'] + '" class="editor_remove">Delete</a>';
                }
            }
        ]
    } );
} );