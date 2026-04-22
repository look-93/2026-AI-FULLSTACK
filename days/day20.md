        //7. parentElement - 나의부모
        let orange = document.querySelector("#orange");
        orange.parentElement.style.border="5px dashed orange";
        orange.parentElement.style.padding="20px";
        orange.parentElement.style.borderRadius="20px"

        //8. 제일가까운 상위부모 - orange 감싸고있는 ul이나 div 같은 경우
        orange.closest("div").style.backgroundColor="black";
        orange.closest("div").style.color="gold";

        //9. 형제요소 
        orange.previousElementSibling.style.textAlign="center"; // orange 이전요소
        orange.nextElementSibling.style.textAlign="right"; // orange 다음요소