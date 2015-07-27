/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    $(document).on('submit', 'form', function (ev) {
        var ck=true;
        $('input[type=text]').each(function () {
            if ($(this).val() === '') {
                alert('Fields not empty');
                ev.preventDefault();
                ck=false;
                return false;
            }
        })
        if(!ck){
            return;
        }
        $('textarea').each(function(){
            if($(this).val()===''){
                alert('Textrea not empty');
                console.log($(this).text());
                ev.preventDefault();
                return false;
            }
        })
        return;
    })
})




