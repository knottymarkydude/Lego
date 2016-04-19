//----------------------------------------------------------- Pagination ----------------------------
// 

/*<![CDATA[*/
            var model = [];

            model.pageNum = /*[[${queryForm.pageNum}]]*/ '1';
            model.numOfPages = /*[[${numOfPages}]]*/ '5';
            model.rows = /*[[${queryForm.rows}]]*/ '10';

            //console.log("pageNum :: + " + model.pageNum);
            //console.log("numOfPages :: + " + model.numOfPages);

            $('#page-selection').bootpag({
                total: model.numOfPages,
                page: model.pageNum,
                maxVisible: 5,
                leaps: true,
                firstLastUse: true,
                first: '←',
                last: '→',
                wrapClass: 'pagination',
                activeClass: 'active',
                disabledClass: 'disabled',
                nextClass: 'next',
                prevClass: 'prev',
                lastClass: 'last',
                firstClass: 'first'
            }).on("page", function (event, num) {
                //$("#content").html("Page " + num);
                $('#search-form input[name=pageNum]').val(num);
                var start = (model.rows * num) - model.rows;
                $('#search-form input[name=start]').val(start);
                $("#search-form").submit();

            });
/*]]>*/