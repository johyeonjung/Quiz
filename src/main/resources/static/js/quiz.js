// Thymeleaf와 함께 JavaScript 코드를 선언합니다.
let quizCards = document.querySelectorAll('.quiz-card'); // 모든 퀴즈 카드를 가져옵니다.
let currentIndex = 0; // 현재 퀴즈 카드의 인덱스를 초기화합니다.

function submitAnswer() {
    let answerInput = document.getElementById('answer'); // 정답 입력 필드를 가져옵니다.
    let userAnswer = answerInput.value.trim(); // 사용자가 입력한 정답을 가져옵니다.

    let correctAnswer = document.getElementById('quizAnswer').textContent.trim(); // 퀴즈의 정답을 가져옵니다.


    //여기서부터 오류 고치기. 답이 똑같이 나옴
    // 정답을 비교합니다.
    if (userAnswer.toLowerCase() === correctAnswer.toLowerCase()) {
        alert('정답입니다.');
    } else {
        alert('오답입니다. 정답 : ' + correctAnswer);
        // 오답 시 다음 문제의 정답으로 초기화합니다.


        correctAnswer = document.getElementById('quizAnswer').textContent.trim();

    }

    // 다음 퀴즈 카드로 이동합니다.
    currentIndex++; // 다음 인덱스로 이동합니다.
    if (currentIndex < quizCards.length) {
        // 현재 보여지고 있는 퀴즈 카드를 숨깁니다.
        quizCards[currentIndex - 1].style.display = 'none';

        // 다음 퀴즈 카드를 보여줍니다.
        quizCards[currentIndex].style.display = 'block';

        // 정답 입력 필드를 초기화합니다.
        answerInput.value = '';
    } else {
        alert('모든 퀴즈를 완료했습니다.'); // 마지막 퀴즈를 완료한 후 알림을 표시합니다.
    }
}

// 초기에 첫 번째 퀴즈 카드를 보여줍니다.
quizCards[currentIndex].style.display = 'block';
