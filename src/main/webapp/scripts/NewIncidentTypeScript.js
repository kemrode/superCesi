MaxNumberOfSelectedIncident();

function MaxNumberOfSelectedIncident(){
    const limitMax = 1;
    $("input[name='incident']").change(function(){
        var max= 3;
        if( $("input[name='incident']:checked").length == limitMax ){
            $("input[name='incident']").attr('disabled', 'disabled');
            $("input[name='incident']:checked").removeAttr('disabled');
        }else{
            $("input[name='incident']").removeAttr('disabled');
        }
    })
}